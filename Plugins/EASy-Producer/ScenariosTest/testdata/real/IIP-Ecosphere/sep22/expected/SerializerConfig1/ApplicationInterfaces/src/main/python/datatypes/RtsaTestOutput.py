
from datetime import datetime

class RtsaTestOutput:
    """Interface of the application data type RtsaTestOutput. 
       Generated by: EASy-Producer."""
 
    
    def getId(self) -> int:
        """Returns the value of {@code id}.
        
           Returns:
             - the value of id"""
        raise NotImplementedError
    
    def getValue1(self) -> float:
        """Returns the value of {@code value1}.
        
           Returns:
             - the value of value1"""
        raise NotImplementedError
    
    def getValue2(self) -> float:
        """Returns the value of {@code value2}.
        
           Returns:
             - the value of value2"""
        raise NotImplementedError
    
    def getConfidence(self) -> float:
        """Returns the value of {@code confidence}.
        
           Returns:
             - the value of confidence"""
        raise NotImplementedError
    
    def getPrediction(self) -> bool:
        """Returns the value of {@code prediction}.
        
           Returns:
             - the value of prediction"""
        raise NotImplementedError
    
    
    def setId(self, v):
        """Changes the value of {@code id}.
        
           Parameters:
             - v -- the new value of id, may be of type int or the corresponding numpy type"""
        raise NotImplementedError
    
    def setValue1(self, v):
        """Changes the value of {@code value1}.
        
           Parameters:
             - v -- the new value of value1, may be of type float or the corresponding numpy type"""
        raise NotImplementedError
    
    def setValue2(self, v):
        """Changes the value of {@code value2}.
        
           Parameters:
             - v -- the new value of value2, may be of type float or the corresponding numpy type"""
        raise NotImplementedError
    
    def setConfidence(self, v):
        """Changes the value of {@code confidence}.
        
           Parameters:
             - v -- the new value of confidence, may be of type float or the corresponding numpy type"""
        raise NotImplementedError
    
    def setPrediction(self, v: bool):
        """Changes the value of {@code prediction}.
        
           Parameters:
             - v -- the new value of prediction"""
        raise NotImplementedError
    
