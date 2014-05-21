using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Monitoring
{
    [XmlRoot(ElementName = "finishedEvent")]
    public class FinishedEvent : Event
    {

        public FinishedEvent() : base("finished")
        {
        }

        public FinishedEvent(string orderId, string dockId, bool isUnloading, bool toBeCleaned)
            : base("finished")
        {
            OrderId = orderId;
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
