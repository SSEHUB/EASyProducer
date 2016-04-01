/**
 * 
 */
using System;
using System.IO;
using System.Xml.Serialization;

namespace Monitoring {

  public class Event {
  	public Event() { }
	
  	public Event(String eventType) 
    {
  		EventType = eventType;
  	}

    [XmlElement(ElementName = "eventType")]
    public String EventType 
    {
  	  get;
      set;
  	}

    public static string SerializeEvent(Event e)
    {
        XmlSerializer ser = new XmlSerializer(e.GetType());
        StringWriter writer = new StringWriter();
        ser.Serialize(writer, e);

        return writer.ToString();
    }
  }

}