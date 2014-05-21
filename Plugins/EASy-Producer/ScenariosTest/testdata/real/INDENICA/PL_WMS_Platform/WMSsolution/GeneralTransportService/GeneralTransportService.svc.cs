using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Threading;
using DataAccess;
using GeneralTransportService.CCSMockServiceReference;
using GeneralTransportService.MaterialMgtServiceReference1;
using GeneralTransportService.RoutingServiceReference;
using Spring.Context;
using Spring.Context.Support;
using log4net;

namespace GeneralTransportService
{
   
    public class GeneralTransportService : IGeneralTransportService
    {
        private static ILog logger = LogManager.GetLogger(typeof(GeneralTransportService));
        private CallbackHandler _callback; // field 1
        
        public CallbackHandler Callback    // propery 2
        {
            get { return _callback; }
            set { _callback = value; _callback.GeneralTransportServiceProp = this; }
        }

        public IGeneralTransportServiceCallback GTcallback { get; set; }

        //public int Shosh { get; set; } // 1 + 2 auf einmal

        public GeneralTransportService()
        {
            //create a new thread: workaround for the 10 Min invocation timeout
            Thread t = new Thread(DummyInvocation);          
            t.Start();
        }

        static void DummyInvocation()
        {
            while (true)
            {
                //Console.WriteLine("invocation!");
                IApplicationContext ctx = ContextRegistry.GetContext();
                ICCSMockService ccsService = (ICCSMockService)ctx.GetObject("ccsMockServiceObjectWSBinding");
                ccsService.Dummy();
                
                Thread.Sleep(300000); // sllep 5 min 
            }
        }

        public bool CallCCSTransport(string boxId, string endDestId)
        {
            logger.Debug("calling CallCCSTransport");

            // Getting Service Objects from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IRoutingService routing = (IRoutingService)ctx.GetObject("routingServiceObjectWSBinding");
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            //IConveyorControlService ccsService = (IConveyorControlService)ctx.GetObject("CCSServiceObjectWSBinding");
            ICCSMockService ccsService = (ICCSMockService)ctx.GetObject("ccsMockServiceObjectWSBinding"); //duplex
            

            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();
            var query = from b in entities.Boxes where b.id == boxId select b;
            var boxes = query.ToList();
            Box box = boxes.First();
            string nextDestId = "";
            string transportMedium = "";

            nextDestId = routing.GetNextDestination(boxId, endDestId);
            if (string.IsNullOrEmpty(nextDestId))
            {
                logger.Debug("the box is at location or error");
                return true; // null if error, empty if the box is already at the location
            }

            transportMedium = routing.GetNextTransportMedium(boxId);
            /*
            ////////////////// EVENT-DRIVEN asynch call
            CCSMockServiceClient cl = new CCSMockServiceClient();                                       // init client
            cl.TransportCompleted += new EventHandler<TransportCompletedEventArgs>(TransportCallback);  // add event handler to TransportCallback
            cl.TransportAsync(boxId, transportMedium, box.location_id, nextDestId);                     // call Transport asynchronously
            ////////////////// asynch call test end);
            */

            ///////////////// CHANNEL FACTORY asynch call
            //// ccsService.Transport(boxId, box.location_id, nextDestId);
            //IAsyncResult arTransport = ccsService.BeginTransport(boxId, transportMedium, box.location_id, nextDestId, TransportCallback, ccsService);
            ccsService.Move(boxId, transportMedium, box.location_id, nextDestId);
            logger.Debug(string.Format("ASYNCHRONOUS CCS MOCK CALL! box_id = {0}, transportMedium = {1}; currentLocation = {2}, nextDestination = {3}", boxId, transportMedium, box.location_id, nextDestId));
            //System.Threading.Thread.Sleep(2000);
            return true;
        }

        /// <summary>
        /// Transports the box to the bin
        /// </summary>
        /// <param name="boxId"></param>
        /// <param name="endDestId"></param>
        /// <returns></returns>
        public void InitiateTransport(string boxId, string endDestId)
        {
            // save reference to callback for later use
            GTcallback = OperationContext.Current.GetCallbackChannel<IGeneralTransportServiceCallback>();
            logger.Debug("calling InitiateTransport");

            // calling ccs transport asynchronously
            CallCCSTransport(boxId, endDestId);
            //gTcallback.TransportFinished(boxId, endDestId);

        }

        public void Dummy()
        {
            //logger.Debug("GeneralTransport dummy Call");
        }

        /*
        public bool CreateTransportentry(string boxId, string binId)
        {
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

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

        public List<Transportentry> GetTransportentries()
        {
            Context c = new Context();
            wmsdbEntities entities = c.GetWMSEntities();

            var query = from r in entities.Transportentries select r;
            var trEntries = query.ToList();
            return (List<Transportentry>)trEntries;
        }

        public List<Transportentry> GetTransportent()
        {
            throw new NotImplementedException();
        }
         * */

        /*
        // ChannelFactory & spring
        void TransportCallback(IAsyncResult ar)
        {
            string transported = ((ICCSMockService) ar.AsyncState).EndTransport(ar);
            logger.Debug("TransportCallback! boxId, locationId " + transported);

            string[] results = transported.Split(' ');
            string boxId = results[0];
            string locationId = results[1];

            // Getting Service Objects from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            
            // set location
            bool locationSet = materialMgt.SetLocation(boxId, locationId);


            // getting transport entry to find the endDestinationId
            string endDestinationId;
            List<Transportentry> trEntries = materialMgt.GetTransportentries();
            Transportentry entry = trEntries.Find(
            delegate(Transportentry t)
            {
                return t.box_id == boxId;
            }
            );
            endDestinationId = entry.bin_id;
            

            if(!(endDestinationId.Equals(locationId)))
            {
                // box is not at the endDestination => CallCCSTransport again!
                CallCCSTransport(boxId, endDestinationId);
            }
            else
            {
                // callback to TransportPlanning that transport was finished
                callback.TransportFinished(boxId, endDestinationId);
                logger.Debug("Box was transported to " + endDestinationId);
            }
            
        }
         * */



    }
}
