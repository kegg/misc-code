class Starship:
    
    def __init__(self, name, registry):
        self.name = name
        self.registry = registry
    
    def __str__(self):
        return "Name: %-20s Registry: %s" % (self.name, self.registry)