// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using DataAccess;
using Spring.Context;
using Spring.Context.Support;
using SuperWebSocket;
using SuperSocket.SocketBase;
using SuperSocket.SocketEngine;
using SuperSocket.SocketBase.Config;
using Apache.NMS;
using Apache.NMS.Util;

namespace SuperWebSocketServer
{
    class Program
    {
        static void Main(string[] args)
        {

            var simulationServer = new SimWebSocketServer();

            simulationServer.Setup(new RootConfig(),
                new ServerConfig
                {
                    Name = "SuperWebSocket",
                    Ip = "Any",
                    Port = 4502, // port for WebSocket messages!
                    Mode = SocketMode.Async
                }, SocketServerFactory.Instance);

            simulationServer.Start();
            Console.WriteLine("Simulation WebSocket Server started on localhost:4502");

            Console.WriteLine("Press any key to stop the server");
            Console.ReadKey();
            simulationServer.Stop();
        }
    }
}
