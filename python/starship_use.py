from starship import Starship

enterprise = Starship('U.S.S. Enterprise', 'NCC-1701-D')
voyager = Starship('U.S.S. Voyager', 'NCC-74656')

print(enterprise)
print(voyager)

enterprise.registry = 'NCC-1701-E'

print(enterprise)