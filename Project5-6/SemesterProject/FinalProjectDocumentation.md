# ADVENTURE GAME THE GAME
*CSCI 4448 - Object Oriented Design and Analysis semester project*

[Project 5 Progress Report](https://github.com/thyo9470/OOAD-Projects/blob/master/Project5-6/Project%205-Status%20Summary.pdf)

[Project 6 Final Report](https://github.com/thyo9470/OOAD-Projects/blob/master/Project5-6/Project%206-Final%20Report.pdf)

**Team Members**
 - Cassidy Carpenter
 - John Stibbards
 - Thomas Young

## Summary

For our Object Oriented Design and Analysis class we have decided to create a simple rogue-lite dungeon crawler game. The game entails exploring different rooms on each floor of the dungeon. Each room can hold treasure, conflict, or puzzles. Fight through the different floors to escape the dungeon.

## Running instructions

1. Clone this project this repo to your device
2. Open the `/Project5-6/SemesterProject` in a java IDE, we used [JetBrain's IntelliJ](https://www.jetbrains.com/idea/)
3. Run the main function found in `/src/Game/Game.java`

## Game Play

#### Floor - Exploration state
![Labeled Floor](https://i.imgur.com/ywg4MzD.png)

#### Enemy Room - Battles
![Labeled Battle](https://i.imgur.com/oLGxI9i.png)

#### Trap Room - Puzzles
![Labeled Puzzle](https://i.imgur.com/4BRvsUT.png)

#### Treasure Room - Item Swap
![Labeled Item Swap](https://i.imgur.com/n12c9VJ.png)

## Game Design

**Game Flow**

![Game Flow](https://i.imgur.com/LxpXzEY.png)

**Graphics Handler**

The graphics handler works by using a combination of an Observer design pattern and Chain-of-Responsibility pattern. The Observer is composed of Interactables (Observables) and GraphicsHandler (Observer). The Graphics handler waits for updates in interactable state. Once there is a change in the interactable state, teh graphics handler is notified.

The graphics are then handled by sending the change state request down a chain of responsability. Each part of the chain can handle a specifc interactable. This allows for better organization and expantion of more graphics components in the future.

![Graphics Handling](https://i.imgur.com/33VjWuP.png)
