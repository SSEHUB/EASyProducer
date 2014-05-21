// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace WMSClient
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            log4net.Config.XmlConfigurator.Configure();  
            Application.Run(new Form1());
        }
    }
}
