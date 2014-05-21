using System;
using System.Configuration;
using System.IO;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;

namespace Monitoring
{
    public class MonitoringMessagePublisher : IDisposable
    {
        private bool isDisposed = false;
        private readonly ISession session;
        private readonly string topicName = null;

        private readonly IConnectionFactory connectionFactory;
        private readonly IConnection connection;
        private readonly IMessageProducer producer;

        const string TOPIC = "monitoring";
        const string BROKER = "tcp://localhost:61616";
        

        public MonitoringMessagePublisher() // read from config file. TODO!!!
        {
            this.topicName = GetQueueTopicString();
            this.connectionFactory = new ConnectionFactory(GetQueueBrokerURIString());


            this.connection = this.connectionFactory.CreateConnection();
            this.connection.Start();
            this.session = connection.CreateSession();
            ActiveMQTopic topic = new ActiveMQTopic(topicName);
            this.producer = this.session.CreateProducer(topic);

        }

        private static string GetQueueBrokerURIString()
        {
            /*
            string dirName = Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase);
            string appConfigPath = new Uri(dirName).LocalPath + "\\app.config";
            ExeConfigurationFileMap configMap = new ExeConfigurationFileMap();
            configMap.ExeConfigFilename = appConfigPath;
            Configuration config = ConfigurationManager.OpenMappedExeConfiguration(configMap, ConfigurationUserLevel.None);
            //string connectionString = config.ConnectionStrings.ConnectionStrings["wmsdbEntities"].ConnectionString;
            ConfigurationSection queue = config.GetSection("queue");
            queue.ToString();            
            return connectionString;
             * */

            return BROKER;
        }

        private static string GetQueueTopicString()
        {
            return TOPIC;
        }

        public void SendMessage(string message)
        {
            if (!this.isDisposed)
            {
                ITextMessage textMessage = this.session.CreateTextMessage(message);
                this.producer.Send(textMessage);
            }
            else
            {
                throw new ObjectDisposedException(this.GetType().FullName);
            }
        }

        #region IDisposable Members

        public void Dispose()
        {
            if (!this.isDisposed)
            {
                this.producer.Dispose();
                this.session.Dispose();
                this.connection.Dispose();
                this.isDisposed = true;
            }
        }

        #endregion
    }
}