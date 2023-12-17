from datetime import datetime

today = datetime.now()
string = "continue"

with open('myfile.txt', 'a') as f:
    while (string != "quit"):
        string = input("Words: ")
        if (string != "quit"):
            f.write(f"[{today}] {string}\n")