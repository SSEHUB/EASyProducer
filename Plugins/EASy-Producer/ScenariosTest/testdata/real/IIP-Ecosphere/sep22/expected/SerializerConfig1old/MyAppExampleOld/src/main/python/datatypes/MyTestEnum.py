from enum import Enum

class MyTestEnum(Enum):
    """Defines the enum MyTestEnum.
       Generated by: EASy-Producer."""
 
    Lit1 = 25
    """Defines the literal Lit1."""
    
    Lit2 = 100
    """Defines the literal Lit2."""
    

    def valueByModelOrdinal(modelOrdinal : int) -> MyTestEnum:
        """Returns an enum literal via its model ordinal.
        
           Parameter:
             - modelOrdinal: the desired ordinal value
           Returns:
             - the enum literal or null"""

        for l in MyTestEnum:
            if l.value == modelOrdinal:
                return l
        return null