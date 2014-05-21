// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using DataAccess;

namespace MaterialMgtService
{
    [ServiceContract]
    public interface IMaterialMgtService
    {
        [OperationContract]
        //[TransactionFlow(TransactionFlowOption.Mandatory)] //In order to call this operation, the client must create a transaction
        [TransactionFlow(TransactionFlowOption.Allowed)] //The operation will participate in a transaction if the client creates one
        bool CreateBox(string boxId);

        [OperationContract]
        bool DeleteBox(string boxId);

        [OperationContract]
        [TransactionFlow(TransactionFlowOption.Allowed)] //The operation will participate in a transaction if the client creates one
        bool CreateMaterial(string materialNumber, string name, string description);

        [OperationContract]
        [TransactionFlow(TransactionFlowOption.Allowed)] //The operation will participate in a transaction if the client creates one
        bool InsertMaterial(string boxId, string content, int quantity);

        [OperationContract]
        [TransactionFlow(TransactionFlowOption.Allowed)]
        bool CreateLocation(string locId, string typeId, string rackId, bool reserved);

        [OperationContract]
        [TransactionFlow(TransactionFlowOption.Allowed)]
        bool CreateTransportentry(string boxId, string binId);

        [OperationContract]
        bool DeleteTransportentry(string boxId);

        [OperationContract]
        bool CreateOrder(string orderId, string dockId, bool isUnloading, bool toBeCleaned);

        [OperationContract]
        bool DeleteOrder(string orderId);

        [OperationContract]
        bool Ready(bool unloading, int numberOfBoxes, bool toBeCleaned);

        [OperationContract]
        void ProcessOrder(string orderId, string dockId, bool isUnloading, bool toBeCleaned);

        [OperationContract]
        void Finished(string orderId);

        [TransactionFlow(TransactionFlowOption.Allowed)] //The operation will participate in a transaction if the client creates one
        [OperationContract]
        bool ReserveBin(string binId);

        [TransactionFlow(TransactionFlowOption.Allowed)]
        [OperationContract]
        bool UnReserveBin(string binId);

        [TransactionFlow(TransactionFlowOption.Allowed)]
        [OperationContract]
        bool SetLocation(string boxId, string binId);

        [OperationContract]
        List<Box> GetBoxes();

        [OperationContract]
        List<Box> GetBoxesOnRS();

        [OperationContract]
        List<Material> GetMaterials();

        [OperationContract]
        List<Position> GetPositions();

        [OperationContract]
        List<Location> GetLocations();

        [OperationContract]
        List<Location> GetStorageBins();

        [OperationContract]
        List<Locationtype> GetLocationTypes();

        [OperationContract]
        List<Rack> GetRacks();

        [OperationContract]
        List<Transportentry> GetTransportentries();

        [OperationContract]
        List<Order> GetOrders();

        [OperationContract]
        string GetLocationtypeIdByName(string locationName);
        [OperationContract]
        string GetRackIdByName(string rackName);

        [OperationContract]
        bool RecreateSampleDatabase(string sqlConnString);
     
    }
}
