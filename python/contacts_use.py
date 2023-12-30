from contacts import Contacts

contact1 = Contacts(1, 23, 'Fred Jones', 'Manager')
contact2 = Contacts(2, 18, 'Joan Johnson', 'Assistant')

print(contact1)
print(contact1.position)
print(contact2)
print(contact2.position)
print(contact1.checkAge())
print(contact2.checkAge())