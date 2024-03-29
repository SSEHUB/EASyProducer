﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MonitoringTest
{
    class SendTest
    {
        string topicName;
        string broker;

        private MessageSubscriber subscriber;
        private MessagePublisher publisher;

        const string CLIENT_ID = "MonitoringClient";
        const string CONSUMER_ID = "MonitoringConsumer";

        public SendTest(string topicName, string broker)
        {
            this.topicName = topicName;
            this.broker = broker;
            //this.subscriber = new MessageSubscriber(topicName, broker, CLIENT_ID, CONSUMER_ID);
            //subscriber.OnMessageReceived += new MessageReceivedDelegate(subscriber_OnMessageReceived);
            //subscriber.Dispose();

            this.publisher = new MessagePublisher(topicName, broker);
            publisher.SendMessage("TEST");
            publisher.Dispose();
        }
            
    }
}
