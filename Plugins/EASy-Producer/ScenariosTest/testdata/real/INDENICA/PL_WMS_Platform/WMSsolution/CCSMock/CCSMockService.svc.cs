using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using ActiveMQMessaging;
using log4net;

namespace CCSMockService
{
    //[ServiceBehavior(ConcurrencyMode = ConcurrencyMode.Reentrant)]
    public class CCSMockService : ICCSMockService
    {
        ILog logger = LogManager.GetLogger(typeof(CCSMockService));
        private ICCSMockServiceCallback ccsCallback;

        // 1 active mq configuration
        const string TOPIC_NAME_UPDATE_SIMULATION = "UpdateSimulationTopic";
        const string TOPIC_NAME_UPDATE_CCS = "UpdateCCSTopic";
        const string BROKER = "tcp://localhost:61616";

        private MessagePublisher publisher;
        private MessageSubscriber subscriber;


        public CCSMockService()
        {
            try
            {
                // active mq
                this.publisher = new MessagePublisher(TOPIC_NAME_UPDATE_SIMULATION, BROKER);

                this.subscriber = new MessageSubscriber(TOPIC_NAME_UPDATE_CCS, BROKER);
                this.subscriber.OnMessageReceived += new MessageReceivedDelegate(subscriber_OnMessageReceived);
            }
            catch (Exception ex)
            {
                logger.Error("Error creating publisher for activemq" + ex.ToString());
            }
        }

        public void Move(string boxId, string transportMediumId, string startLocId, string endLocId)
        {
            // save reference to callback for later use
            ccsCallback = OperationContext.Current.GetCallbackChannel<ICCSMockServiceCallback>();
            

            logger.Debug("calling Move in CCSMockService");

            string message = ConstantsLibrary.Constants.MOVE_BOX + " " + boxId + " " + transportMediumId + " " +
                             startLocId + " " + endLocId;
            this.publisher.SendMessage(message);
            logger.Debug("Message published: " + message);
            // TODO on message!! not here
            

            //return boxId + " " + endLocId;
        }

        public void Dummy()
        {
            //logger.Debug("CCSMockService dummy call");
        }


        // on receiving of mq messages
        void subscriber_OnMessageReceived(string message)
        {
           string[] results = message.Split(' ');
           string command = results[0];
           if (command == ConstantsLibrary.Constants.MOVE_FINISHED)
           {
               string boxId = results[1];
               string endLocationId = results[2];
               logger.Debug("Message received: " + message);
               ccsCallback.MoveFinished(boxId, endLocationId);
           }
           else
           {
               logger.Error("unknown command");
           }
        }
    }
}
