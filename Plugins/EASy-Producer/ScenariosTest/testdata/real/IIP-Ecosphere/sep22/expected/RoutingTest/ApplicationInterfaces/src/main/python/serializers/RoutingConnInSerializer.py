from json import JSONEncoder
import json
from datetime import datetime
from iip.TypeTranslatorToString import TypeTranslatorToString
import Registry
from datatypes.RoutingConnIn import RoutingConnIn
from datatypes.RoutingConnInImpl import RoutingConnInImpl

class RoutingConnInEncoder(JSONEncoder):
    """JSON encoder class for RoutingConnIn.
    Generated by: EASy-Producer."""

    def default(self, o):
        """Provides access to the attributes in o.
        
        Parameters:
          - o -- the object to serialize
        Returns:
          dict
            the attributes
        """
        return o.__dict__
    

class RoutingConnInSerializer(TypeTranslatorToString):
    """JSON transport serializer for RoutingConnIn.
       Generated by: EASy-Producer."""
                
    def __init__(self):
        """Initializes the transformer.""" 
        Registry.serializers["RoutingConnIn"] = self
        Registry.types[RoutingConnIn] = "RoutingConnIn"
        Registry.serializers["RoutingConnInImpl"] = self # there is a serializer for the Impl
        Registry.types[RoutingConnInImpl] = "RoutingConnIn" # the Impl maps back to the type name
    
    def readFrom(self, data: str) -> RoutingConnIn:
        """Turns bytes into a String.
        
        Parameters:
          - data -- the data string
        Returns:
          object
            the deserialized object
        """
    
        result = RoutingConnInImpl()
        result.__dict__ = json.loads(data)
        return result

    def writeTo(self, source: RoutingConnIn) -> str:
        """Turns an object into a String.
        
        Parameters:
          - source -- the object
        Returns:
          bytes
            the serialized data string
        """
        
        return RoutingConnInEncoder().encode(source).encode("UTF-8").decode()
        
RoutingConnInSerializer()
