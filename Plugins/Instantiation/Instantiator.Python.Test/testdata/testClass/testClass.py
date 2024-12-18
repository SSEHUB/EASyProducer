
class TestClass(BaseClass):
    var1 = 420
    var2: int = 69

    def getVar1(self):
        """Returns the value of var1.
        Returns:
            return value of var1
        """
        return self.var1

    def setVar1(self, var1):
        """Sets the value of var1.
        Parameters:
            - var1 -- the new value
        """
        self.var1 = var1

    def getVar2(self) -> int:
        """Returns the value of var2.
        Returns:
            int
                return value of var2
        """
        return self.var2

    def setVar2(self, var2: int):
        """Sets the value of var2.
        Parameters:
            - var2 (int) -- the new value
        """
        self.var2 = var2

    def __init__(self):
        """some comment"""
        pass

    def __init__(self):
        pass

    def method1(self):
        pass

    def method2(self):
        """some method"""
        pass



class TestClass2:
    """comment for TestClass2"""

    class InnerClass:
        pass


