using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace TransportPlanningService
{
    [ServiceContract]
    public interface ITransportPlanningService
    {
        // returns the reserved binId or "" if not reserved!
        [OperationContract]
        string StoreBox(string boxId);

    }

}
