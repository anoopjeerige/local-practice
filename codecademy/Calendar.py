"""
Command Line Calendar
Program for a basic calendar to allow user to
view, add event into, update exisiting event of,
delete existing event of calendar.
"""
from time import sleep, strftime, localtime

FIRSTNAME = "anoop"

calendar = {}


def welcome():
    print "Welcome " + FIRSTNAME
    print "Opening you calendar..."
    sleep(1)
    print strftime("%A %B %d, %Y", localtime())
    print strftime("%H:%M:%S", localtime())
    sleep(1)
    print "What would you like to do?"


def start_calendar():
    welcome()
    start = True
    while start:
        user_choice = raw_input(
            "Enter A to Add, U to Update, V to View, D to Delete, X to Exit:")
        if user_choice == "V":
            if len(calendar.keys()) < 1:
                print "Calendar is empty."
            else:
                print calendar
        elif user_choice == "U":
          date = raw_input("What date? ")
          update = raw_input("Enter the update: ")
          calendar[date] = update
          print "Calendar Updated"
          print calendar
        elif user_choice == "A":
          event = raw_input("Enter event: ")
          date = raw_input("Enter date (MM/DD/YYYY): ")
          if len(date) > 10 or int(date[6:]) < int(strftime("%Y", localtime())):
            print "Invalid date."
            try_again = raw_input("Try again? Y for Yes, N for No: ")
            try_again = try_again.upper()
            if try_again == "Y":
              continue
            else:
              start = False
          else:
            calendar[date] = event
            print "Event added successfully"
        elif user_choice == "D":
          if len(calendar.keys()) < 1:
            print "Calendar empty"
          else:
            event = raw_input("What event?")
            for date in calendar.keys():
              if event == date:
                del calender[date]
                print "Event successfully deleted"
              else:
                print "Invalid event"
            
         elif user_choice == "X":
          start = False
         else:
          print "Invalid command"
          start = False

start_calendar()
