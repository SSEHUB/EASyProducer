// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ActiveMQMessaging;
using Apache.NMS;
using Apache.NMS.Util;
using DataAccess;
using Spring.Context;
using Spring.Context.Support;
using SuperSocket.SocketBase;
using SuperWebSocket;
using SuperWebSocketServer.MaterialMgtServiceReference;

namespace SuperWebSocketServer
{
    class SimWebSocketServer : WebSocketServer
    {
        private List<WebSocketSession> m_Sessions = new List<WebSocketSession>();
        private object m_SessionSyncRoot = new object();

        // 1 active mq configuration
        private const string TOPIC_NAME_UPDATE_SIMULATION = "UpdateSimulationTopic";
        private const string TOPIC_NAME_UPDATE_CCS = "UpdateCCSTopic";
        private const string BROKER = "activemq:tcp://localhost:61616";

        public MessagePublisher publisher;
        private MessageSubscriber subscriber;

        // 2 websocket messages
        private const string CREATE_BOX = "CREATE_BOX";
        private const string CREATE_STORAGEBIN = "CREATE_STORAGEBIN";
        private const string RELOAD_SIMULATION = "RELOAD_SIMULATION";

       
        public SimWebSocketServer()
        {
            try
            {
                // active mq
                this.publisher = new MessagePublisher(TOPIC_NAME_UPDATE_CCS, BROKER);

                this.subscriber = new MessageSubscriber(TOPIC_NAME_UPDATE_SIMULATION, BROKER);
                this.subscriber.OnMessageReceived += new MessageReceivedDelegate(subscriber_OnMessageReceived);

                // websocket
                this.NewMessageReceived +=
                    new SessionEventHandler<WebSocketSession, string>(WebSocketServer_NewMessageReceived);
                this.NewSessionConnected +=
                    new SessionEventHandler<WebSocketSession>(WebSocketServer_NewSessionConnected);
                this.SessionClosed +=
                    new SessionEventHandler<WebSocketSession, CloseReason>(WebSocketServer_SessionClosed);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!!!!!!!!!!!!!!!!!!!!!!!" + ex.ToString());
            }
        }

        // on receiving of ACTIVE MQ messages. forward message to the SimSite (queue -> SimServer -> SimSite)
        void subscriber_OnMessageReceived(string message)
        {
            Console.WriteLine("Message from CCS: " + message);
            if (message == "RELOAD_SIMULATION")
            {
                foreach (WebSocketSession wss in m_Sessions)
                {
                    ReloadSimulation(wss);
                }
            }
            else
            {
                foreach (WebSocketSession wss in m_Sessions)
                {
                    wss.SendResponse(message);
                }
            }
            //publisher.SendMessage("vot tebe na zurück");
        }

        protected void WebSocketServer_NewMessageReceived(WebSocketSession session, string e)
        {
            //char[] arr = e.ToCharArray();
            //Array.Reverse(arr);
            //string reverseString = new string(arr);
            //session.SendResponse(reverseString);
            //Console.WriteLine("SimServer: " + reverseString);

            Console.WriteLine("Message from SimSite: " + e);
            // forward message from SimSite to active MQ
            publisher.SendMessage(e);
        }

        private void WebSocketServer_NewSessionConnected(WebSocketSession session)
        {
            lock (m_SessionSyncRoot)
                m_Sessions.Add(session);

            Console.WriteLine("ws session created");
            ReloadSimulation(session);
        }

        private void WebSocketServer_SessionClosed(WebSocketSession session, CloseReason reason)
        {
            Console.WriteLine("ws session closed");
            lock (m_SessionSyncRoot)
                m_Sessions.Remove(session);
        }

        // sends existing boxes and storageBins from MaterialMgtService to Simulation WebSite
        private void ReloadSimulation(WebSocketSession wss)
        {
            // Getting Service Object from Spring
            IApplicationContext ctx = ContextRegistry.GetContext();
            IMaterialMgtService materialMgt = (IMaterialMgtService)ctx.GetObject("materialMgtServiceObjectWSBinding");

            wss.SendResponse(RELOAD_SIMULATION);

            List<Location> storageBins = materialMgt.GetStorageBins().ToList();
            foreach (Location sb in storageBins)
            {
                wss.SendResponse(CREATE_STORAGEBIN + " " + sb.id);
            }

            List<Box> boxes = materialMgt.GetBoxes().ToList();
            foreach (Box box in boxes)
            {
                wss.SendResponse(CREATE_BOX + " " + box.id + " " + box.location_id);
            }
        }

        
    }
}
