from datatypes.KRec13Anon import KRec13Anon

from datetime import datetime

class KRec13AnonImpl(KRec13Anon):
    """Implementation of the application data type KRec13Anon. 
       Generated by: EASy-Producer."""
 
    kip: str
    intField: int
    stringField: str
    
    def getKip(self) -> str:
        """Returns the value of {@code kip}.
        
           Returns:
             - the value of kip"""
        return self.kip
    
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
    
    
    def setKip(self, v: str):
        """Changes the value of {@code kip}.
        
           Parameters:
             - v -- the new value of kip"""
        self.kip = v
    
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
    
