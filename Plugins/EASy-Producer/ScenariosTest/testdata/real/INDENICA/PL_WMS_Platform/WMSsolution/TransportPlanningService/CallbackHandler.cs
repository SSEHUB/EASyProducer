using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using log4net;
using Spring.Context;
using Spring.Context.Support;
using TransportPlanningService.GeneralTransportServiceReference;
using TransportPlanningService.MaterialMgtServiceReference;

namespace TransportPlanningService
{
    public class CallbackHandler : GeneralTransportServiceReference.IGeneralTransportServiceCallback
    {
        private static ILog  logger= LogManager.GetLogger(typeof(TransportPlanningService));

        public void TransportFinished(string boxId, string endDestId)
        {
            // box is at the endDestination!

            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            //IGeneralTransportService generalTransport = (IGeneralTransportService)ctx.GetObject("generalTransportObject");
            
            // 1. +++++++++++++++++ DELETE TRANSPORT ENTRY +++++++++++++++++
            materialMgt.DeleteTransportentry(boxId);

            // 2. +++++++++++++++++ UNRESERVATION +++++++++++++++++
            materialMgt.UnReserveBin(endDestId);
            logger.Debug("TransportFinished! boxId =" + boxId + " new binId=" + endDestId);
        }

        
    }
}