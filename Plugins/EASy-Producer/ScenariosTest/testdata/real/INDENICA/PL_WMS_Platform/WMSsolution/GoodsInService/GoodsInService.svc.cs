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
using GoodsInService.MaterialMgtServiceReference;
using log4net;
using DataAccess;
using System.Data.Common;
using Spring.Context;
using Spring.Context.Support;
using System.Transactions;


namespace GoodsInService
{
    public class GoodsInService : IGoodsInService
    {
        private static ILog logger = LogManager.GetLogger(typeof(GoodsInService));
        public string RegisterBox(string boxId, string materialId, int amount)
        {           
            logger.Debug("Calling RegisterBox");

            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            string locationId = "RS"; //TODO: register a new box always on RS! 
            using (TransactionScope scope = new TransactionScope(TransactionScopeOption.RequiresNew))
            {
                logger.Info("****************************************************** STARTING TRANSACTION");

                // Registrating new box
                
                bool boxCreated = materialMgt.CreateBox(boxId);
                bool materialInserted = materialMgt.InsertMaterial(boxId, materialId, amount);
                if (boxCreated && materialInserted)
                {
                    logger.Debug(string.Format("Box registered! boxId = {0}, materialId = {1}, amount = {2}", boxId,
                                               materialId, amount));
                    logger.Info("****************************************************** TRANSACTION COMPLETED");
                    scope.Complete();
                }
                else
                {
                    logger.Info("****************************************************** TRANSACTION ABORTED");
                    locationId = "";
                }
            }
            return locationId;
        }

        public string GetData(int value)
        {
            return string.Format("You entered: {0}", value);
        }

        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }
    }
}
