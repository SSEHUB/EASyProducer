using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;

namespace GeneralTransportService
{
    [ServiceContract(CallbackContract = typeof(IGeneralTransportServiceCallback))]
    public interface IGeneralTransportService
    {
        [OperationContract(IsOneWay = true)]
        void InitiateTransport(string boxId, string binId);

        [OperationContract]
        void Dummy();

        /*
        [OperationContract]
        bool CreateTransportentry(string boxId, string binId);

        [OperationContract]
        bool DeleteTransportentry(string boxId);
         
        [OperationContract]
        List<Transportentry> GetTransportentries();
        */
    }


}
