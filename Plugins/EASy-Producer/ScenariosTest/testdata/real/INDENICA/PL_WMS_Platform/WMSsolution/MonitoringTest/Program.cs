using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MonitoringTest
{
    class Program
    {
        static void Main(string[] args)
        {

            // 1 active mq configuration
            string topicName = "wmscalls";
            //string broker = "tcp://192.168.56.101:61616";
            string broker = "tcp://localhost:61616";

            
            SendTest test = new SendTest(topicName, broker);
            Console.WriteLine("Monitoring test is running");

            Console.WriteLine("Press any key to stop it");
            Console.ReadKey();
        }

        
    }
}
