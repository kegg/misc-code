# testing a conversion from a string to an int that shouldn't work
try:
    x = 'Fred'
    i = int(x)
except ValueError:
    print("Nope, no can do.")
except:
    print("Something else went wrong")
# let's see what happens