using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Monitoring
{

    [XmlRoot(ElementName = "customEvent")]
    public class CustomEvent : Event
    {
        public CustomEvent() : base("CustomEvent")
        {
           
        }

        [XmlElement(ElementName = "custom")]
        public String LocationName
        {
            get;
            set;
        }
    }
}
