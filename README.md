# APCSCodeYourOwn
This app plays Route 66, a modern remake of The Oregon Trail
Team: Jordan Hanleybrown, Nathan Sun, Yusuf Moazzam

## Classes
### Person.java (Jordan)
- Includes one String for character name and two ints for money and health
- Includes methods for modifying and returning the instance variables
### Car.java (Nathan)
- Includes one String for car model and 5 ints for mileage, gas in the car, capacity of food car can carry, and amount of food in the car
includes methods for modifying and returning the instance variables
### Game.java (Jordan and Nathan)
- Includes the Person character, Car vehicle, 4 ints (previous location, new location, day game is on, and max amount of days), and one boolean for if the character is arrested or not.
- Includes methods that: prints info about the current turn (printInfo()), runs a random event for the player (doRandomEvent()), runs a turn in which the player decides what to do that day (turn()), checks if the player crossed a state line (locationEvents()), checks if the game is over (checkGameOver()), and prints the game over message when the game ends (printFinalStats())
### Main.java (Yusuf)
- Includes the int gameOver and the Game round
- Includes the method main: while the game is not over, runs the Game methods. when the game ends, exits the loop and prints the game over method

## How to
- Answer game's prompts in the Run terminal
- Play the modern version of The Oregon Trail, travel 2500 miles from Santa Monica to Chicago without dying or going to jail

## Reqs
### Switch Statements
- A switch statement is used to switch the int variable corresponding to what caused the game to end in order to print the correct game over message
### Serialization
### Hashmaps
### Exception Handling
- The user must input an int between 0 and 3 for the action they choose to do each day. Exceptional handling is used to make sure the input is an int, and additional logic is used to make sure the int is between 0 and 3. If either isn't true, the user must continue inputting until a valid number is inputed