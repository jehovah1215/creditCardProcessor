# Sapient Test  :: ADD and VIEW Credit Cards

# Requirement : 

    Two REST Endpoints :
	•	*Add* will create a new credit card for a given name, card number, and limit
	•	Card numbers should be validated using Luhn 10
	•	New cards start with a £0 balance
	•	for cards not compatible with Luhn 10, return an error
	•	*Get all* returns all cards in the system
  
#  Features Covered :
    1. Two REST endpoints for adding card and getting all cards added.
    2. Input and output in JSON.
    3. Request validation on card number(Luhn), amount and name of user.
    4. Logging using SL4J.
    5. Exception handling wherever required.
    6. Junit Tests with coverage of 60 % +.

# Assumptions. :
  
 1. Basic validation on amount(limit/balance) added.(works for pound as of now).
 2. Name has only characters
 3. Only Backend code is provided
 4. Only GET and ADD_CARD methods implemented , no add-balance or debit-balance implemented so balance will be always as "0";
 5. In-Memory DB used. (HashMap).
 
 # Prerequisite to run App :
 
 1. maven 
 2. java (jdk 8 or above)
 3. Editor (Eclipse or IntelliJ)
 4. Spring tool suite installed
 5. Github
 
 # Follow the steps below to run this application 
  1. Open terminal and run command * git clone 
 
 
