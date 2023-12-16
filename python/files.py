from datetime import datetime

today = datetime.now()

with open('myfile.txt', 'a') as f:
    string = input("Words: ")
    f.write(f"[{today}] {string}\n")