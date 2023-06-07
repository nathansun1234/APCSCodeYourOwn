# APCSCodeYourOwn
Team: Jordan Hanleybrown, Nathan Sun, Yusuf Moazzam
This game plays Route 66, a modern remake of the Oregon Trail.

## Classes
### Person.java (Jordan)
### Car.java (Nathan)
### Game.java (Jordan and Nathan)
### Main.java (Yusuf)
## How to
- respond to the game's prompts in the Run terminal
- game over when character either dies, is put in jail, or wins.

## Structure
## Purpose:
- Play the modern version of the Oregon Trail, travel 2500 miles from Santa Monica to Chicago without dying or going to jail. 

## Reqs:
User input: responding to prompts given by game
Hashmap:
Serialization:
Exception handling: implemented in the primary user input loop. The game requires an int of value 0, 1, 2, or 3, if another int is entered, or even another type, the game will wait until a valid input without throwing an exception
Switch statements: switch statements are used to print the correct game over message by switching an int corresponding to what triggered the game over
