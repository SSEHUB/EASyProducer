using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;

namespace RoutingService
{
    [ServiceContract]
    public interface IRoutingService
    {
        [OperationContract]
        string GetNextDestination(string boxId, string binId);

        [OperationContract]
        string GetNextTransportMedium(string boxId);
       
    }
    
}
