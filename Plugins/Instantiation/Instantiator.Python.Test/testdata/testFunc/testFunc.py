from module import someDecorator3
def dummy():
    pass

def dummy2():
    """dummy function 2"""
    pass

def function1(p1, p2: int, p3: int) -> int:
    """
    Parameters:
        - p3 (int) -- 3rd parameter
    Returns:
        int
            return sum of p1, p2, p3
    """
    return p1 + p2 + p3

@someDecorator
@module.someDecorator2(arg1, arg2)
@someDecorator3
def function2():
    pass

retObject().funcInObject()
func("some string", TestClass(lambda i : i+1))
