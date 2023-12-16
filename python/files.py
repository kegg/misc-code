with open('myfile.txt', 'a') as f:
    string = input("Words: ")
    f.write(string)
    f.write('\n')