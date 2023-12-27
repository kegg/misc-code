class Contacts:

    def __init__(self, id, age, name, position):
        self.id = id
        self.age = age
        self.name = name
        self._position = position
        
    def __str__(self):
        return "id: %d, age: %d, name: %s, position: %s" % (self.id, self.age, self.name, self._position)
    
    def checkAge(self):
        if (self.age > 20):
            return "%s is over 20" % (self.name)
        else:
            return "%s is under 20" % (self.name)
    
    @property
    def position(self):
        return self._position
    
    @position.setter
    def position(self, value):
        if value == 'Manager' or value == 'Assistant':
            self._position = value
        else:
            print("Position is invalid. No changes made.")