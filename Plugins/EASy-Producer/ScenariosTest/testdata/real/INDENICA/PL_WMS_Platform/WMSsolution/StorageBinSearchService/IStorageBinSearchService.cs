using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;

namespace StorageBinSearchService
{
    [ServiceContract]
    public interface IStorageBinSearchService
    {
        [OperationContract]
        [TransactionFlow(TransactionFlowOption.Allowed)] //The operation will participate in a transaction if the client creates one
        string SearchNextFreeBin(string boxId);

        /*
        [OperationContract]
        bool StoreBox(string boxId, string locationId);
         * */

    }
}
