import sqlite3
conn = sqlite3.connect('life.db')

c = conn.cursor()

c.execute("CREATE TABLE words (id integer primary key, note text)")

c.execute("INSERT INTO words (note) VALUES ('Hi, Hello There!')")

conn.commit()

for row in c.execute('SELECT * FROM words'):
  print row

conn.close()