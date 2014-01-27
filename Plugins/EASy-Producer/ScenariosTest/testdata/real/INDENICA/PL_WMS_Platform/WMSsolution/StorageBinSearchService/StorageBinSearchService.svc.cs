using System;
using System.Collections.Generic;
using System.Data.Common;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;
using log4net;

namespace StorageBinSearchService
{

    public enum StorageStrategy
    {
        Simple,
        Abc
    }

    [ServiceBehavior(TransactionIsolationLevel = System.Transactions.IsolationLevel.Serializable, TransactionTimeout = "00:01:00")]
    public class StorageBinSearchService : IStorageBinSearchService
    {
        private static ILog logger = LogManager.GetLogger(typeof(StorageBinSearchService));

        public StorageStrategy Strategy { get; set; }

        /// <summary>
        /// Searches the next free bin with the type = StorageBin
        /// </summary>
        /// <param name="boxId">The id of the box to be stored</param>
        /// <returns>id of the next free bin with type = StorageBin or null if there is no free bin</returns>
        [OperationBehavior(TransactionScopeRequired = true, TransactionAutoComplete = true)]
        public string SearchNextFreeBin(string boxId)
        {
            logger.Debug("calling SearchNextFreeBin");
            logger.Debug("SearchStrategy is " + this.Strategy);

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var queryBoxes = from b in entities.Boxes select b;
            var boxes = queryBoxes.ToList();

            var queryLocations = from l in entities.Locations select l;
            var locations = queryLocations.ToList();

            var queryLocationtypeId = from ln in entities.Locationtypes where ln.name == ConstantsLibrary.Constants.STORAGE_BIN select ln.id;
            var locationIds = queryLocationtypeId.ToList();
            string storageBinTypeId = locationIds.First();

            // AS: IMO, Location should not represent StorageBins and Transport Locations such as Conveyor or Picking Station at the same time
            //     Hence, this code needs to be redesigned after refactoring Location any way.
            //     Therefore, I basically just have duplicated the previous code that selects just any free storage location
            if(this.Strategy.Equals(StorageStrategy.Simple))
            {
                // AS: this is just the copy of the previous code
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
                        return location.LocationID;
                    }
                }
                return null;
            }
            else if (this.Strategy.Equals(StorageStrategy.Abc))
            {
                var boxCat = from box in boxes where box.id == boxId select box.abc_cat;

                var queryLeftOuterJoin =
                    from location in locations
                    join box in boxes on location.id equals box.location_id into gj
                    where location.type.Equals(storageBinTypeId) && location.abc_cat == boxCat.First()

                    from o in gj.DefaultIfEmpty()

                    select new
                    {
                        LocationID = location.id,
                        Reserved = location.reserved,
                        LocationType = location.type,
                        BoxId = (o == null) ? "NULL" : o.id
                    };
                ////http://smehrozalam.wordpress.com/2009/06/10/c-left-outer-joins-with-linq/

                foreach (var location in queryLeftOuterJoin)
                {
                    if (location.BoxId == "NULL" && location.Reserved != true)
                    {
                        //logger.Debug("empty and not reserved box was found. Id = " + location.LocationID);
                        return location.LocationID;
                    }
                }
                return null;                
            } else
            {
                logger.Warn("A new type of StorageStrategy has been defined, but not implemented!");
                return null;
            }

        }

        

    }
}
