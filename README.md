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
  1. Open terminal and run command :
     * git clone git@github.com:jehovah1215/creditCardProcessor.git 
     * cd creditCardProcessor 
     
                              OR 
     Unzip the the project file attached and navigate to root folder where pom.xml exists.
     
  2. * git checkout master
     
  3. Navigate to root folder where pom.xml exists ()if you are not already there and run below command :
     * mvn clean install
  4. If step results in build success(which ideally should ;) ) proceed with below command :
     * mvn spring-boot:run 
  5. By this time application must be running on 8080 port now if you have postman or ARC to send the request use else run following
      curl commands in another terminal from your system.
      
      a. To add a valid credit card to the table : 
      ```curl -H "Content-Type: application/json" -X POST -d '{"userName":"Bob","cardNumber":"012850003540600","limit":"£4000"}' http://localhost:8080/addCard```
         
      b. To add another credit card :
          ``` curl -H "Content-Type: application/json" -X POST -d '{"userName":"Steve","cardNumber":"012850003520800","limit":"£2000"}' http://localhost:8080/addCard
          ```
          
      c. To get all the cards added till now :
          ``` curl -H GET  http://localhost:8080/getAllCards ```
      
      d. To add a card with invalid card number (expect an exception and look for logs):
           ``` curl -H "Content-Type: application/json" -X POST -d '{"userName":"Steve","cardNumber":"0129990003520800","limit":"£2000"}' http://localhost:8080/addCard
          ```
      e. To add a card with invalid amount and name (expect an exception and look for logs):
           ``` curl -H "Content-Type: application/json" -X POST -d '{"userName":"@S1teve","cardNumber":"012850003520800","limit":"£20df00"}' http://localhost:8080/addCard
          ```
          
       # Sample input-output 
       
           % curl -H "Content-Type: application/json" -X POST -d '{"userName":"Bob","cardNumber":"012850003540600","limit":"£4000"}' http://localhost:8080/addCard

           % curl -H GET  http://localhost:8080/getAllCards 
                
           ``` [{"creditCardDetails":{"userName":"Bob","cardNumber":"012850003540600","limit":"£4000"},"balance":"£0"}] ```
           
  # Choice of technologies : 
            Database : MySQL (to achieve transactional and ACID features.)
                       Make CardNumber as primary key .
                       Shard the db.
                       Use master slave .
                       CAP theorem : Consistency and Partioning 
           
           
  # TODO :: 
            1. Increase test coverage .
            2. Implement better validation checks of currency and make currency checker more generic.
            3. Implement strategy design pattern for dynamically choosing card validation algorithms for future.
            4. Make DB instance Singleton so that only one instance is shared throughout.
            5. Add more REST endpoints for debit and credit amount to the card so that get all balance can show changes in balance.
            6. Add more comments. 
            7. Better README :P
            
            -----THANKS-----
            
           
          
          
      
      
     
     
 
 
