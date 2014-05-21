using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Monitoring
{
    [XmlRoot(ElementName = "readyEvent")]
    public class ReadyEvent : Event
    {

        public ReadyEvent() : base("ready")
        {
        }

        public ReadyEvent(int numberOfBoxes, bool toBeCleaned)
            : base("ready")
        {
            NumberOfBoxes = numberOfBoxes;
            ToBeCleaned = toBeCleaned;
        }

        [XmlElement(ElementName = "numberOfBoxes")]
        public int NumberOfBoxes
        {
            get;
            set;
        }

        [XmlElement(ElementName = "toBeCleaned")]
        public bool ToBeCleaned
        {
            get;
            set;
        }
    }
}
