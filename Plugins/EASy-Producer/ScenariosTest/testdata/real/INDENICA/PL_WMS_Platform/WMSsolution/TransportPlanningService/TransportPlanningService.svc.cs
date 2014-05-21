using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Threading;
using System.Transactions;
using log4net;
using Spring.Context;
using Spring.Context.Support;
using TransportPlanningService.GeneralTransportServiceReference;
using TransportPlanningService.MaterialMgtServiceReference;
using TransportPlanningService.StorageBinSearchServiceReference;

namespace TransportPlanningService
{
    public class TransportPlanningService : ITransportPlanningService
    {
        private static ILog logger = LogManager.GetLogger(typeof(TransportPlanningService));

        public TransportPlanningService()
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
                IGeneralTransportService generalTransport = (IGeneralTransportService)ctx.GetObject("generalTransportServiceObject");
                generalTransport.Dummy();
                
                Thread.Sleep(300000); // sllep 5 min 
            }
        }


        public string StoreBox(string boxId)
        {
           
            // Getting Service Objects from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();

            IStorageBinSearchService storageBinSearch =
                (IStorageBinSearchService) ctx.GetObject("storageBinSearchServiceObjectWSBinding");
            IMaterialMgtService materialMgt = (IMaterialMgtService) ctx.GetObject("materialMgtServiceObjectWSBinding");
            IGeneralTransportService generalTransport = (IGeneralTransportService)ctx.GetObject("generalTransportServiceObject");
            //IGeneralTransportService generalTransport = new
            //    DuplexChannelFactory<IGeneralTransportService>(new CallbackHandler(), "WSDualHttpBinding_IGeneralTransportService").
            //        CreateChannel();

            bool freeBinFound = false;
            bool freeBinReserved = false;
            string nextFreeBin = null;
            bool transportEntyCreated = false;

            // 1. +++++++++++++++++ RESERVATION +++++++++++++++++

            using (TransactionScope scope = new TransactionScope(TransactionScopeOption.RequiresNew))
            {
                logger.Info("****************************************************** STARTING TRANSACTION");

                // find next free bin
                nextFreeBin = storageBinSearch.SearchNextFreeBin(boxId);
                if (nextFreeBin != null)
                    freeBinFound = true;

                // reserve free bin
                if (freeBinFound)
                    freeBinReserved = materialMgt.ReserveBin(nextFreeBin);

                // 2. +++++++++++++++++ CREATE TRANSPORT ENTRY +++++++++++++++++
                if (freeBinReserved)
                    transportEntyCreated = materialMgt.CreateTransportentry(boxId, nextFreeBin);

                // transport box to the reserved bin
                if (transportEntyCreated)
                {
                    logger.Info("****************************************************** TRANSACTION COMPLETED");
                    scope.Complete();
                }
                else
                {
                    logger.Info("****************************************************** TRANSACTION ABORTED");
                }
            }

            

            // 3. +++++++++++++++++ INITIATE TRANSPORT +++++++++++++++++
            if (transportEntyCreated)
            {
                generalTransport.InitiateTransport(boxId, nextFreeBin);
                return nextFreeBin;

                /*
                 
                DuplexChannelFactory<IGeneralTransportServiceChannel> generalTransportFactory = new DuplexChannelFactory<IGeneralTransportServiceChannel>
                    (new CallbackHandler(), "WSDualHttpBinding_IGeneralTransportService");
                IGeneralTransportService generalTransportChannel = generalTransportFactory.CreateChannel();
                generalTransportChannel.InitiateTransport("", "");
                */

            }

            return "";
        }
    }
}
