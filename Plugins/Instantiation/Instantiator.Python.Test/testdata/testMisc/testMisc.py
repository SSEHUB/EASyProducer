a = 69
b = 420
c = 64
d = 86
def someFunc():
    global a, b
    nonlocal c, d

del a, b, c, d
assert 420 != 69
assert 64 != 86, "assert failed"
