// /////////////////////////////////////
// 
// © Siemens AG, 2012. All Rights Reserved
// 
// /////////////////////////////////////
using System;
using System.Collections;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Web.Configuration;
using System.Xml;

namespace DataAccess
{
    public class Context
    {
        public wmsdbEntities GetWMSEntities()
        {
            string connectionString = GetConnectionString();
            wmsdbEntities context = new wmsdbEntities(connectionString);
            context.ContextOptions.LazyLoadingEnabled = false; // to avoid circular references!!
            return context;
        }

        /// <summary>
        /// extracts the connectionString for "WMSEntities" from the app.config in DataAccess
        /// </summary>
        /// <returns>string connectionString</returns>
        public string GetConnectionString()
        {
            string dirName = Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase);
            string appConfigPath = new Uri(dirName).LocalPath + "\\app.config";
            ExeConfigurationFileMap configMap = new ExeConfigurationFileMap();
            configMap.ExeConfigFilename = appConfigPath;
            Configuration config = ConfigurationManager.OpenMappedExeConfiguration(configMap, ConfigurationUserLevel.None);
            string connectionString = config.ConnectionStrings.ConnectionStrings["wmsdbEntities"].ConnectionString;
            return connectionString;

        }

    }
}
