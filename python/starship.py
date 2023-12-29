class Starship:
    
    def __init__(self, name, registry, className):
        self.name = name
        self.registry = registry
        self.className = className
    
    def __str__(self):
        return "Name: %-20s Registry: %-12s Class: %s" % (self.name, self.registry, self.className)