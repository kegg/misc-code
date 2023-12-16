from datetime import datetime,timedelta
today = datetime.now()
print(today)

tomorrow = today + timedelta(days=1)
print(tomorrow)

an_hour_ago = today - timedelta(hours=1)
print(an_hour_ago)