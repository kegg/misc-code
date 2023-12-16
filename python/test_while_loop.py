x = False

while x is not True:
    print("Choose Your Pain")
    print("A) Say Hello")
    print("B) Say Goodbye")
    print("C) Exit")

    i = input("Choice: ")
    if i.upper() == "C":
        x = True