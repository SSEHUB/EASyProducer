from json import JSONEncoder
import json
from datetime import datetime
from iip.TypeTranslatorToString import TypeTranslatorToString
import Registry
from datatypes.RtsaTestOutput import RtsaTestOutput
from datatypes.RtsaTestOutputImpl import RtsaTestOutputImpl

class RtsaTestOutputEncoder(JSONEncoder):
    """JSON encoder class for RtsaTestOutput.
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
    

class RtsaTestOutputSerializer(TypeTranslatorToString):
    """JSON transport serializer for RtsaTestOutput.
       Generated by: EASy-Producer."""
                
    def __init__(self):
        """Initializes the transformer.""" 
        Registry.serializers["RtsaTestOutput"] = self
        Registry.types[RtsaTestOutput] = "RtsaTestOutput"
        Registry.serializers["RtsaTestOutputImpl"] = self # there is a serializer for the Impl
        Registry.types[RtsaTestOutputImpl] = "RtsaTestOutput" # the Impl maps back to the type name
    
    def readFrom(self, data: str) -> RtsaTestOutput:
        """Turns bytes into a String.
        
        Parameters:
          - data -- the data string
        Returns:
          object
            the deserialized object
        """
    
        result = RtsaTestOutputImpl()
        result.__dict__ = json.loads(data)
        return result

    def writeTo(self, source: RtsaTestOutput) -> str:
        """Turns an object into a String.
        
        Parameters:
          - source -- the object
        Returns:
          bytes
            the serialized data string
        """
        
        return RtsaTestOutputEncoder().encode(source).encode("UTF-8").decode()
        
RtsaTestOutputSerializer()