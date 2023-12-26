for n in range(99, -1, -1):
    if (n > 1):
        print(n, "bottles of beer on the wall")
        print(n, "bottles of beer...")
        print("take one down pass it around,", n-1, "bottles of beer on the wall")
    elif (n == 1):
        print(n, "bottle of beer on the wall")
        print(n, "bottle of beer...")
        print("take one down pass it around,", n-1, "bottles of beer on the wall")
    elif (n == 0):
        print("no more bottles of beer on the wall")
        print("no bottles of beer...")
        print("go to the store, and buy some more! 99 bottles of beer on the wall...")