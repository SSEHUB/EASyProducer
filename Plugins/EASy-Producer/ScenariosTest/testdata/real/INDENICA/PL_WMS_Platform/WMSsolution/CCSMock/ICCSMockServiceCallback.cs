using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;

namespace CCSMockService
{
    public interface ICCSMockServiceCallback
    {
        [OperationContract(IsOneWay = true)]
        void MoveFinished(string boxId, string endDestId);

    }
}