class Contacts:

    def __init__(self, id, age, name):
        self.id = id
        self.age = age
        self.name = name
        
    def __str__(self):
        return "id: %d, age: %d, name: %s" % (self.id, self.age, self.name)
    
    def checkAge(self):
        if (self.age > 20):
            return "%s is over 20" % (self.name)
        else:
            return "%s is under 20" % (self.name)
            