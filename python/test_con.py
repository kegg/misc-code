# testing a conversion from a string to an int that shouldn't work
try:
    x = 'Fred'
    i = int(x)
except:
    print("Nope, no can do.")
# let's see what happens