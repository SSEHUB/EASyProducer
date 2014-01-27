// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Text.RegularExpressions;
using System.Xml.Serialization;
using log4net;
using DataAccess;
using System.Data;
using System.Data.Common;
using Monitoring;
using Spring.Context;
using Spring.Context.Support;


namespace MaterialMgtService
{
    [ServiceBehavior(TransactionIsolationLevel = System.Transactions.IsolationLevel.Serializable, TransactionTimeout = "00:01:00")]
    public class MaterialMgtService : IMaterialMgtService
    {
        private static ILog logger = LogManager.GetLogger(typeof(MaterialMgtService));

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool CreateBox(string boxId)
        {           
            logger.Debug("calling CreateBox");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;
            String abcCat = "C";
            Random r = new Random();
            int nextCat = r.Next(0, 2);
            if(nextCat == 0)
            {
                abcCat = "A";
            } else if (nextCat == 1)
            {
                abcCat = "B";
            }else
            {
                abcCat = "C";
            }


            try{
                Box newBox = new Box { id = boxId, location_id = "RS", abc_cat = abcCat};
                entities.AddToBoxes(newBox);
                entities.SaveChanges();
                logger.Debug(string.Format("New box created! boxId = {0}", newBox.id));
                result = true;



                // sending the event about the creation TODO!!!!!!!!!!
                CustomEvent co = new CustomEvent();
                co.LocationName = boxId;
                string eventAsString = Event.SerializeEvent(co);
                logger.Debug("box creation event was serialized: " + eventAsString);

                MonitoringMessagePublisher mpublisher = new MonitoringMessagePublisher();
                mpublisher.SendMessage(eventAsString);
                logger.Debug("Event about the box creation was sent to a defined queue using Monitoring");


            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }

            return result;
        }

        public bool DeleteBox(string boxId)
        {
            logger.Debug("calling DeleteBox");
    
            try
            {
                Context c = new Context();
                wmsdbEntities entities = c.GetWMSEntities();

                var query0 = from p in entities.Positions select p;
                var positions = query0.ToList();

                Position position = positions.Find(
                    delegate(Position p)
                    {
                        return p.box_id == boxId;
                    }
                    );

                if (position != null)
                {
                    entities.Positions.DeleteObject(position);
                    entities.SaveChanges();
                    logger.Debug("position deleted");
                }


                var query = from b in entities.Boxes select b;
                var boxes = query.ToList();

                Box box = boxes.Find(
                    delegate(Box b)
                        {
                            return b.id == boxId;
                        }
                    );

                if (box != null)
                {
                    entities.Boxes.DeleteObject(box);
                    entities.SaveChanges();
                    logger.Debug("box deleted");
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (Exception ex)
            {
                return false;
            }
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool CreateMaterial(string materialNumber, string name, string description)
        {
            logger.Debug("calling CreateMaterial");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;
            
            try
            {
                Material newMaterial = new Material { materialNumber = materialNumber, name = name, description = description };
                entities.AddToMaterials(newMaterial);
                entities.SaveChanges();
                logger.Debug(string.Format("New material created! materialNumber = {0}", newMaterial.materialNumber));
                result = true;
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool InsertMaterial(string boxId, string materialId, int amount)
        {
            logger.Debug("calling InsertMaterial");
            
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;
            try
            {
                Position position = new Position { box_id = boxId, material_id = materialId, amount = amount };
                entities.AddToPositions(position);
                entities.SaveChanges();
                logger.Debug(string.Format("Material inserted! boxId = {0}, materialId= {1}, amount = {2}", position.box_id, position.material_id, position.amount));
                result = true;
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool CreateLocation(string locId, string typeId, string rackId, bool reserved)
        {
            logger.Debug("calling CreateLocation");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                Location newLocation = new Location { id = locId, type = typeId, rack_id = rackId, reserved = reserved };
                entities.AddToLocations(newLocation);
                entities.SaveChanges();
                logger.Debug(string.Format("New location created! id = {0}, typeId = {1}, rackId = {2} reserved = {3}", newLocation.id, newLocation.type, newLocation.rack_id, newLocation.reserved));
                result = true;
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool CreateTransportentry(string boxId, string binId)
        {
            logger.Debug("calling CreateTransportEntry");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                Transportentry newTrEntry = new Transportentry() { box_id = boxId, bin_id = binId };
                entities.AddToTransportentries(newTrEntry);
                entities.SaveChanges();
                logger.Debug(string.Format("New transportentry created! box_id = {0}, bin_id = {1}", newTrEntry.box_id, newTrEntry.bin_id));
                result = true;
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        public void ProcessOrder(string orderId, string dockId, bool isUnloading, bool toBeCleaned)
        {
            logger.Debug("calling ProcessOrder");
            if (CreateOrder(orderId, dockId, isUnloading, toBeCleaned))
                logger.Debug("ProcessOrder success");
            else
                logger.Debug("ProcessOrder failure");
        }

        /// <summary>
        /// Sends Finished Event to the "monitoring" Queue Topic, using Monitoring Library.
        /// </summary>
        public void Finished(string orderId)
        {
            //FinishedEvent e = new FinishedEvent(toBeCleaned);
            //string eventAsString = Event.SerializeEvent(e);

            //MonitoringMessagePublisher mpublisher = new MonitoringMessagePublisher();
            //mpublisher.SendMessage(eventAsString);
            //mpublisher.Dispose();

            logger.Debug("calling Finished. OrderId = " + orderId);
            if (this.DeleteOrder(orderId))
                logger.Debug("Finished success");
            else
                logger.Debug("Finished failure");
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Box> GetBoxes()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            

            var query = from b in entities.Boxes select b;
            var boxes = query.ToList();
            return boxes;
        }

        public List<Box> GetBoxesOnRS()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();


            var query = from b in entities.Boxes where b.location_id == "RS"select b;
            //var storageBinsQuery = from l in entities.Locations where l.type == storageBinTypeId select l;
            var boxes = query.ToList();
            return boxes;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Material> GetMaterials()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from m in entities.Materials select m;
            var materials = query.ToList();
            return materials;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Position> GetPositions()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from p in entities.Positions select p;
            var positions = query.ToList();
            return positions;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Location> GetLocations()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from l in entities.Locations select l;
            var locations = query.ToList();
            return locations;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Location> GetStorageBins()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var queryLocationtypeId = from ln in entities.Locationtypes where ln.name == ConstantsLibrary.Constants.STORAGE_BIN select ln.id;
            var locationIds = queryLocationtypeId.ToList();
            string storageBinTypeId = locationIds.First();

            var storageBinsQuery = from l in entities.Locations where l.type == storageBinTypeId select l;
            var storageBins = storageBinsQuery.ToList();
            return storageBins;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Locationtype> GetLocationTypes()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from lt in entities.Locationtypes select lt;
            var locationTypes = query.ToList();
            return locationTypes;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Rack> GetRacks()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from r in entities.Racks select r;
            var racks = query.ToList();
            return racks;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public List<Transportentry> GetTransportentries()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from r in entities.Transportentries select r;
            var trEntries = query.ToList();
            return trEntries;
        }

        public List<Order> GetOrders()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from o in entities.Orders select o;
            var orders = query.ToList();
            return orders;
        }

        public string GetLocationtypeIdByName(string locationName)
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from ln in entities.Locationtypes where ln.name == locationName select ln.id;
            var locationIds = query.ToList();
            if (locationIds.Count > 0)
                return locationIds.First();
            return null;
        }

        public string GetRackIdByName(string rackName)
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from r in entities.Racks where r.name == rackName select r.id;
            var rackIds = query.ToList();
            if (rackIds.Count > 0)
                return rackIds.First();
            return null;
        }


        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool ReserveBin(string binId)
        {
            logger.Debug("calling ReserveBin");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                var query = from l in entities.Locations select l;
                var locations = query.ToList();
                foreach (var location in locations)
                {
                    if (location.id == binId && location.reserved == false)
                    {
                        location.reserved = true;
                        entities.SaveChanges();
                        logger.Debug(string.Format("Bin with binId = {0} reserved", binId));
                        result = true;
                        break;
                    }
                }
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool UnReserveBin(string binId)
        {
            logger.Debug("calling UnReserveBin");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                var query = from l in entities.Locations select l;
                var locations = query.ToList();
                foreach (var location in locations)
                {
                    if (location.id == binId)
                    {
                        location.reserved = false;
                        entities.SaveChanges();
                        logger.Debug(string.Format("Bin with binId = {0} unreserved", binId));
                        result = true;
                        break;
                    }
                }
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public bool SetLocation(string boxId, string binId)
        {
            logger.Debug("calling SetLocation");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                var query = from b in entities.Boxes where b.id == boxId select b;
                var boxes = query.ToList();

                foreach (var box in boxes) // should be only one box in the list!
                {
                    box.location_id = binId;
                    entities.SaveChanges();
                    logger.Debug(string.Format("Location set! boxId = {0}, locationId = {1}", box.id, box.location_id));
                    result = true;
                    break;
                }
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }


        public bool DeleteTransportentry(string boxId)
        {
            logger.Debug("calling DeleteTransportentry");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from t in entities.Transportentries select t;
            var transportentries = query.ToList();

            Transportentry trEntry = transportentries.Find(
            delegate(Transportentry t)
            {
                return t.box_id == boxId;
            }
            );

            entities.Transportentries.DeleteObject(trEntry);
            entities.SaveChanges();
            return true;
        }

        public bool CreateOrder(string orderId, string dockId, bool isUnloading, bool toBeCleaned)
        {
            logger.Debug("calling CreateOrder");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            bool result = false;

            try
            {
                Order newOrder = new Order { orderId = orderId, dockId = dockId, isUnloading = isUnloading, toBeCleaned = toBeCleaned };
                entities.AddToOrders(newOrder);
                entities.SaveChanges();
                logger.Debug(string.Format("Order created! orderId = {0}", newOrder.orderId));
                result = true;
                
                // sending the event about the creation to Monitoring TODO!!!!!!!!!! ??????????
                
            }
            catch (Exception ex)
            {
                logger.Error(ex.ToString());
                result = false;
            }
            return result;
        }

        public bool DeleteOrder(string orderId)
        {
            logger.Debug("calling DeleteOrder");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from o in entities.Orders select o;
            var orders = query.ToList();

            Order order = orders.Find(
            delegate(Order o)
            {
                return o.orderId == orderId;
            }
            );

            entities.Orders.DeleteObject(order);
            entities.SaveChanges();
            return true;
        }

        /// <summary>
        /// Identifies if WMS can handle an order or not
        /// </summary>
        /// <param name="unloading">bool - true for an unloading order, false for a loading order</param>
        /// <param name="numberOfBoxes">integer - number of boxes to be unloaded or loades</param>
        /// <param name="toBeCleaned">bool - true for track has to be cleaned after an unloading order</param>
        /// <returns>bool- true if WMS can handle the order, false if not</returns>
        public bool Ready(bool unloading, int numberOfBoxes, bool toBeCleaned)
        {
            // TODO: move to StorageBinSearch??? below is the same code like in SeachrNextFreeBin!!!!!!
            logger.Debug("calling Ready");
            int numberOfFreeBins = 0;

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var queryBoxes = from b in entities.Boxes select b;
            var boxes = queryBoxes.ToList();

            var queryLocations = from l in entities.Locations select l;
            var locations = queryLocations.ToList();

            var queryLocationtypeId = from ln in entities.Locationtypes where ln.name == ConstantsLibrary.Constants.STORAGE_BIN select ln.id;
            var locationIds = queryLocationtypeId.ToList();
            string storageBinTypeId = locationIds.First();

            var queryLeftOuterJoin =
                from location in locations
                join box in boxes on location.id equals box.location_id into gj
                where location.type.Equals(storageBinTypeId)

                from o in gj.DefaultIfEmpty()

                select new
                {
                    LocationID = location.id,
                    Reserved = location.reserved,
                    LocationType = location.type,
                    BoxId = (o == null) ? "NULL" : o.id
                };
            //http://smehrozalam.wordpress.com/2009/06/10/c-left-outer-joins-with-linq/
            foreach (var location in queryLeftOuterJoin)
            {
                if (location.BoxId == "NULL" && location.Reserved != true)
                {
                    //logger.Debug("empty and not reserved box was found. Id = " + location.LocationID);
                    numberOfFreeBins ++;
                }
            }

            if (numberOfFreeBins >= numberOfBoxes)
                return true;
            else
                return false;
        }

        public bool RecreateSampleDatabase(string sqlConnString)
        {
            FileInfo file1 = new FileInfo("C:\\repository\\WMS\\docs\\1CreateDatabaseAndTables.sql");
            FileInfo file2 = new FileInfo("C:\\repository\\WMS\\docs\\2InsertExampleData.sql");
            string script = file1.OpenText().ReadToEnd();
            script = script + "\r\n" + file2.OpenText().ReadToEnd();
            try
            {
                using (SqlConnection conn = new SqlConnection(sqlConnString))
                {
                    conn.Open();
                    Regex regex = new Regex(@"\r{0,1}\nGO\r{0,1}\n");
                    string[] commands = regex.Split(script);

                    foreach (string c in commands)
                    {
                        if (c != string.Empty)
                        {
                            using (SqlCommand command = new SqlCommand(c, conn))
                            {
                                command.ExecuteNonQuery();
                                command.Dispose();
                            }
                        }
                    }
                    conn.Close();
                }
                return true;
            }
            catch (Exception e)
            {
                logger.Error("could not reload the database!!");
                logger.Error(e.ToString());
                return false;
            }
        }
    }
}
