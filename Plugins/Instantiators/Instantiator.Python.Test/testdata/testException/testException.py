try:
    raise ValueError
except ValueError:
    pass
except OtherError as e:
    pass
except:
    pass

try:
    raise ValueError("error message")
except* ValueError:
    pass
except* OtherError as e:
    pass
except*:
    pass
else:
    pass
finally:
    pass
