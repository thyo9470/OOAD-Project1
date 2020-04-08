
# Rent-A-Ride the car rental company (Project 3)

Cassidy Carpenter

John Stibbards

Thomas Young

## Running Instructions
The main function is found in Simulator.java.
Open the project and run it from there.

## Language and Environment
Used Java in IntelliJ IDE for development

## Design and Assumptions
**Car**
  - All cars are created using the factory design pattern at the start of the program
    - We create 24 cars are the start. 5 of each types excluding luxury cars where there are only 4 of
  - Cars are then stored in an object pool and given out as they are requested
    - When a car is requested a decorator pattern is used to attach extra features such as a GPS to the car
  - License plates are numerical values starting at 1000

**Car Storage**
  - This acts as both the factory and object pool for cars.
    - When it is created it populates itself with cars and then handles their distribution throughout the simulation

**Customer**
  - Acts as an observer in the observer design pattern. Customers observe the store and wait for it to open to first return any due rentals and then possibly rent.
  - There are three customer types: Casual, Regular, and Business
    - Casual:
      - Rents 1 car for 1-3 nights
      - 90% Chance to add satellite radio ( no better way to enjoy a car ride then some tunes )
      - 25% Chance to add a GPS ( it's not about the destination, but the journey )
      - 50% Chance to add a car seat ( day trips with the family are always fun )
        - Will rent 1 - 4 car seats
    - Regular:
      -  Rents 1-3 cars for 3-5 nights
      - 50% Chance to add satellite radio
      - 50% Chance to add GPS
      - 50% Chance to add a car seat
        - Will rent 1 - 4 car seats 
    - Business:
      - Only rent 3 cars for 7 nights
      - 10% Chance to add satellite radio ( most business people believe music is a waste of time )
      - 70% Chance to add a GPS ( they must work as efficiently as possible )
      -  0% Chance to add a car seat ( kinda weird to bring a child on a business trip )

**Store**
  - Acts as the subject in the observer pattern.
  - Assumption: The store deals with all returns and for that reason when a customer makes a return they just give the store a reference to themselves an the store looks up what cars need to be returned.
  - Assumption: Cars can only be returned, they cannot be un-returned. If a customer needs their car back they have to make another rental.

**Logger**
  - Acts as an observer for the observer pattern. Observes the store and logs the store's activity at the end of each day
  - Assumption: The instructions said to print the daily information of the store every time the store opened. I felt this didn't make sense since it also asked to print the daily revenue even though the store has made no money when just opening. For these reasons, it made more sense to log the activity of the store every time the store closed.

**Simulator**
  - Has two main purposes:
    - Setup: Creating all objects needed and then setting up anything they need ( such as registering observers with subjects )
    - Simulation: Only opens and closes the store. Everything else reacts to these events. Additionally increments the day after the closing the store.
  - Assumption: People and things inherently know what day it is. For that reason the getCurrentDay method in Simulator is static. This way everyone can know what the day is without needing to ask. 
  - Assumption: Nothing in the simulator should have reference to the simulator object. This way the simulator and actual simulation depend on each other as little as possible

**CarDecorator**
  - This is composed of the three extras cars can have added to them when rented:
    - Car Seat
    - GPS
    - Satalite Radio
  - As the name suggests, this is implemented using the decorator pattern
