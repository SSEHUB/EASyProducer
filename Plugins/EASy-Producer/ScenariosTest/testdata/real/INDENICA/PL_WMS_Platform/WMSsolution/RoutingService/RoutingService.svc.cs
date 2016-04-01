using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;
using log4net;
using Spring.Context;
using Spring.Context.Support;

namespace RoutingService
{
    public class RoutingService : IRoutingService
    {
        private static ILog logger = LogManager.GetLogger(typeof(RoutingService));

        /// <summary>
        /// Determines the next destination for the box on the way to the endlocation
        /// </summary>
        /// <param name="boxId"> id of the box to be transported </param>
        /// <param name="binId"> end location </param>
        /// <returns>
        /// id of the next destination (location) if there is one
        /// "" if the box is already at the end location
        /// null else
        /// </returns>
 

        public string GetNextDestination(string boxId, string binId)
        {
            logger.Debug("calling GetNextDestination");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            // get Box
            var query1 = from b in entities.Boxes where b.id == boxId select b;
            var boxes = query1.ToList();
            Box box = boxes.First();
            // get StorageBin
            var query2 = from l in entities.Locations where l.id == binId select l;
            var locations = query2.ToList();
            Location storageBin = locations.First();

            // get ReceptionStation
            var query3 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.RECEPTION_STATION
                         select l;
            Location receptionStation = query3.First();

            // get TransferStation
            var query4 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.TRANSFER_STATION
                         select l;
            Location transferStation = query4.First();


            // routing in 2 steps: 1) from RS to TS 2) from TS to SB
            if (box.location_id == storageBin.id)
                return "";          // destination = no, with id = ""
            else if (box.location_id == receptionStation.id)
                return transferStation.id;         // destination = "transferStation" with id = TS
            else if (box.location_id == transferStation.id)
                return binId;       // destination = "StorageBin" with id = binId

            /* OLD!! // routing in 2 steps: 1) from C to RF 2) from RF to SB
            var query3 = from l in entities.Locations 
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.CONVEYOR select l;
            Location conveyor = query3.First();

            var query4 = from l in entities.Locations 
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.RACK_FEEDER select l;
            Location rackFeeder = query4.First();

            if (box.location_id == location.id)
                return "";          // destination = no, with id = ""
            else if (box.location_id == conveyor.id)
                return rackFeeder.id;         // destination = "RackFeeder" with id = RF1
            else if (box.location_id == rackFeeder.id)
                return binId;       // destination = "StorageBin" with id = binId

             */


            return null;
        }

        public string GetNextTransportMedium(string boxId)
        {
            logger.Debug("calling GetNextTransportMedium");

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            // get Box
            var query1 = from b in entities.Boxes where b.id == boxId select b;
            var boxes = query1.ToList();
            Box box = boxes.First();

            // get ReceptionStation 
            var query3 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.RECEPTION_STATION
                         select l;
            Location receptionStation = query3.First();

            // get TransferStation 
            var query4 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.TRANSFER_STATION
                         select l;
            Location transferStation = query4.First();

            // get Conveyor 
            var query5 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.CONVEYOR
                         select l;
            Location conveyor = query5.First();

            // get RackFeeder 
            var query6 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.RACK_FEEDER
                         select l;
            Location rackFeeder = query6.First();

            if (box.location_id == receptionStation.id)
                return conveyor.id;             // transportMedium = Conveyor, with id = "C"
            else if (box.location_id == transferStation.id)
                return rackFeeder.id;           // destination = "RackFeeder" with id = RF1
            return null;                        // box is not at RS or TS => null


            /* OLD
            var query1 = from b in entities.Boxes where b.id == boxId select b;
            var boxes = query1.ToList();
            Box box = boxes.First();

            var query3 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.CONVEYOR
                         select l;
            Location conveyor = query3.First();

            var query4 = from l in entities.Locations
                         join lt in entities.Locationtypes on l.type equals lt.id
                         where lt.name == ConstantsLibrary.Constants.RACK_FEEDER
                         select l;
            Location rackFeeder = query4.First();

            if (box.location_id == conveyor.id)
                return conveyor.id;             // transportMedium = Conveyor, with id = "C"
            else if (box.location_id == rackFeeder.id)
                return rackFeeder.id;           // destination = "RackFeeder" with id = RF1
            return null;                        // box is not on the conveyor or rackfeeder => null
             * 
             */
        }
    }
}
