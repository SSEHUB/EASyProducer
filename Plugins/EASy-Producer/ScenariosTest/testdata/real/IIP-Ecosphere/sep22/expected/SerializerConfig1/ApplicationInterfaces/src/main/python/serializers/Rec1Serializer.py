from json import JSONEncoder
import json
from datetime import datetime
from iip.TypeTranslatorToString import TypeTranslatorToString
import Registry
from datatypes.Rec1 import Rec1
from datatypes.Rec1Impl import Rec1Impl

class Rec1Encoder(JSONEncoder):
    """JSON encoder class for Rec1.
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
    

class Rec1Serializer(TypeTranslatorToString):
    """JSON transport serializer for Rec1.
       Generated by: EASy-Producer."""
                
    def __init__(self):
        """Initializes the transformer.""" 
        Registry.serializers["Rec1"] = self
        Registry.types[Rec1] = "Rec1"
        Registry.serializers["Rec1Impl"] = self # there is a serializer for the Impl
        Registry.types[Rec1Impl] = "Rec1" # the Impl maps back to the type name
    
    def readFrom(self, data: str) -> Rec1:
        """Turns bytes into a String.
        
        Parameters:
          - data -- the data string
        Returns:
          object
            the deserialized object
        """
    
        result = Rec1Impl()
        result.__dict__ = json.loads(data)
        return result

    def writeTo(self, source: Rec1) -> str:
        """Turns an object into a String.
        
        Parameters:
          - source -- the object
        Returns:
          bytes
            the serialized data string
        """
        
        return Rec1Encoder().encode(source).encode("UTF-8").decode()
        
Rec1Serializer()