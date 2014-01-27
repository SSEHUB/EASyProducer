using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using log4net;
using Spring.Context;
using Spring.Context.Support;

namespace WMSClient
{
    public class GeneralTransportCallbackHandler : GeneralTransportServiceReference.IGeneralTransportServiceCallback
    {
        
        public void TransportFinished(string boxId, string endDestId)
        {
            // box is at the endDestination!

            //IApplicationContext ctx = ContextRegistry.GetContext();
            //IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");
            
            // 1. +++++++++++++++++ DELETE TRANSPORT ENTRY +++++++++++++++++
            //materialMgt.DeleteTransportentry(boxId);

            // 2. +++++++++++++++++ UNRESERVATION +++++++++++++++++
            //materialMgt.UnReserveBin(endDestId);
            Console.WriteLine("TransportFinished! boxId =" + boxId + " new binId=" + endDestId);
        }

        
    }
}