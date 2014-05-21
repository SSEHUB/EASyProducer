using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;
using DataAccess;
using GeneralTransportService.CCSMockServiceReference;
using GeneralTransportService.MaterialMgtServiceReference1;
using log4net;
using Spring.Context;
using Spring.Context.Support;

namespace GeneralTransportService
{
    //[CallbackBehaviorAttribute(ConcurrencyMode = ConcurrencyMode.Reentrant)]
    public class CallbackHandler : CCSMockServiceReference.ICCSMockServiceCallback
    {
        private static ILog logger = LogManager.GetLogger(typeof(GeneralTransportService));
        //public IGeneralTransportService GtService { get; set; }

        public GeneralTransportService GeneralTransportServiceProp { get; set; }

        public void MoveFinished(string boxId, string locationId)
        {
            //logger.Debug("TransportFinished! boxId, locationId " + transported);

            
            // Getting Service Objects from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            // set location
            bool locationSet = materialMgt.SetLocation(boxId, locationId);


            // getting transport entry to find the endDestinationId
            string endDestinationId;
            List<Transportentry> trEntries = materialMgt.GetTransportentries().ToList();
            Transportentry entry = trEntries.Find(
            delegate(Transportentry t)
            {
                return t.box_id == boxId;
            }
            );
            endDestinationId = entry.bin_id;

            
            if (!(endDestinationId.Equals(locationId)))
            {
                // box is not at the endDestination => CallCCSTransport again!
                GeneralTransportServiceProp.CallCCSTransport(boxId, endDestinationId);
            }
            else
            {
                // callback to TransportPlanning that transport was finished
                //callback.TransportFinished(boxId, endDestinationId); TODO
                logger.Debug("Box was transported to " + endDestinationId);
                //IGeneralTransportServiceCallback gTcallback = OperationContext.Current.GetCallbackChannel<IGeneralTransportServiceCallback>();
                //gTcallback.TransportFinished(boxId, endDestinationId);


                GeneralTransportServiceProp.GTcallback.TransportFinished(boxId, endDestinationId);
                //IGeneralTransportService ct = (IGeneralTransportService) OperationContext.Current.Channel;
                logger.Debug("fertig");
            }
            


            //logger.Debug("TransportFinished! boxId =" + boxId + " new binId=" + endDestId);
        }
    }
}