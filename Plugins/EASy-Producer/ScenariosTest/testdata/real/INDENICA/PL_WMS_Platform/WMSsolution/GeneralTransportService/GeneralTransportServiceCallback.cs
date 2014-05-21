using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;

namespace GeneralTransportService
{
    public interface IGeneralTransportServiceCallback
    {
        [OperationContract(IsOneWay = true)]
        void TransportFinished(string boxId, string endDestId);

        
    }
}