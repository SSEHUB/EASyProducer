from datatypes.Rec1 import Rec1

from datetime import datetime

class Rec1Impl(Rec1):
    """Implementation of the application data type Rec1. 
       Generated by: EASy-Producer."""
 
    intField: int
    stringField: str
    
    def getIntField(self) -> int:
        """Returns the value of {@code intField}.
        
           Returns:
             - the value of intField"""
        return self.intField
    
    def getStringField(self) -> str:
        """Returns the value of {@code stringField}.
        
           Returns:
             - the value of stringField"""
        return self.stringField
    
    
    def setIntField(self, v):
        """Changes the value of {@code intField}.
        
           Parameters:
             - v -- the new value of intField, may be of type int or the corresponding numpy type"""
        if ("numpy" in str(type(v))):
           self.intField = v.item()
        else:
           self.intField = v
    
    def setStringField(self, v: str):
        """Changes the value of {@code stringField}.
        
           Parameters:
             - v -- the new value of stringField"""
        self.stringField = v
    