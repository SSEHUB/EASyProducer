using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace CCSMockService
{
    [ServiceContract(CallbackContract = typeof(ICCSMockServiceCallback))]
    public interface ICCSMockService
    {
        [OperationContract(IsOneWay = true)]
        void Move(string boxId, string transportMedium, string startLocId, string entLocId);

        [OperationContract]
        void Dummy();
        
    }


}
