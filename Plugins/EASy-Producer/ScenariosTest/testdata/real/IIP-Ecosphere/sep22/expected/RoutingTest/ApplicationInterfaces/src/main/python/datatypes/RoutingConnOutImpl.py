from datatypes.RoutingConnOut import RoutingConnOut

from datetime import datetime

class RoutingConnOutImpl(RoutingConnOut):
    """Implementation of the application data type RoutingConnOut. 
       Generated by: EASy-Producer."""
 
    serNr: int
    data: str
    
    def getSerNr(self) -> int:
        """Returns the value of {@code serNr}.
        
           Returns:
             - the value of serNr"""
        return self.serNr
    
    def getData(self) -> str:
        """Returns the value of {@code data}.
        
           Returns:
             - the value of data"""
        return self.data
    
    
    def setSerNr(self, v):
        """Changes the value of {@code serNr}.
        
           Parameters:
             - v -- the new value of serNr, may be of type int or the corresponding numpy type"""
        if ("numpy" in str(type(v))):
           self.serNr = v.item()
        else:
           self.serNr = v
    
    def setData(self, v: str):
        """Changes the value of {@code data}.
        
           Parameters:
             - v -- the new value of data"""
        self.data = v
    