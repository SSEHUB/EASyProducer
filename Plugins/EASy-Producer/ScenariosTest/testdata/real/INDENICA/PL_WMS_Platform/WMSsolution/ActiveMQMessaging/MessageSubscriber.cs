using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;

namespace ActiveMQMessaging
{
    public delegate void MessageReceivedDelegate(string message);

    public class MessageSubscriber : IDisposable
    {
        private readonly string queueName = null;
        private readonly IConnectionFactory connectionFactory;
        private readonly IConnection connection;
        private readonly ISession session;
        private readonly IMessageConsumer consumer;
        private bool isDisposed = false;
        public event MessageReceivedDelegate OnMessageReceived;

        public MessageSubscriber(string queueName, string brokerUri)
        {
            this.queueName = queueName;
            this.connectionFactory = new ConnectionFactory(brokerUri);
            this.connection = this.connectionFactory.CreateConnection();
            
            this.connection.Start();
            this.session = connection.CreateSession();
            ActiveMQQueue queue = new ActiveMQQueue(queueName);

            this.consumer = this.session.CreateConsumer(queue);
            this.consumer.Listener += new MessageListener(OnMessage);
        }

        public void OnMessage(IMessage message)
        {
            ITextMessage textMessage = message as ITextMessage;
            if (this.OnMessageReceived != null)
            {
                this.OnMessageReceived(textMessage.Text);
            }
        }

        #region IDisposable Members

        public void Dispose()
        {
            if (!this.isDisposed)
            {
                this.consumer.Dispose();
                this.session.Dispose();
                this.connection.Dispose();
                this.isDisposed = true;
            }
        }

        #endregion
    }
}