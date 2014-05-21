using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Monitoring
{
    [XmlRoot(ElementName = "processOrderEvent")]
    public class ProcessOrderEvent : Event
    {

        public ProcessOrderEvent() : base("processOrder")
        {
        }

        public ProcessOrderEvent(string orderId, string dockId, bool isUnloading, bool toBeCleaned)
            : base("processOrder")
        {
            OrderId = orderId;
            NumberOfBoxes = 3.ToString();
            DockId = dockId;
            IsUnloading = isUnloading;
            ToBeCleaned = toBeCleaned;
        }

        [XmlElement(ElementName = "orderId")]
        public string OrderId
        {
            get;
            set;
        }

        [XmlElement(ElementName = "numberOfBoxes")]
        public string NumberOfBoxes
        {
            get;
            set;
        }

        [XmlElement(ElementName = "dockId")]
        public string DockId
        {
            get;
            set;
        }

        [XmlElement(ElementName = "isUnloading")]
        public bool IsUnloading
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
