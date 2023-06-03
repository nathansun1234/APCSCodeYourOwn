import java.util.*;
public class Game {
    private Person character;
    private Car vehicle;
    private int oldLocation;
    private int location;
    private int day;
    private int dayLimit;
    private boolean arrested;
    Scanner scan = new Scanner(System.in);
    public Game() {
        //asks for values for character, car, settings
        System.out.println("Welcome to Route 66!");//todo: write intro

        System.out.println("Choose your difficulty: (0 = easy, 1 = medium, 2 = hard)");
        int difficulty = scan.nextInt();

        System.out.println("Name your character:");
        String name = scan.next();

        System.out.println("Choose your car: (0 = Lamborghini Aventador, 1 = Ford F150, 2 = Honda Civic)"); //todo: add info about cars
        int carId = scan.nextInt();

        //inits variables
        character = new Person(name, difficulty);
        vehicle = new Car(carId);
        oldLocation = 0;
        location = 0; 
        day = 1;
        arrested = false;
        if (difficulty == 0) {
            dayLimit = 40;
        }
        else if (difficulty == 1) {
            dayLimit = 30;
        }
        else if (difficulty == 2) {
            dayLimit = 25;
        }
    }

    public void printInfo() {
        System.out.println("Day " + day + " / " + dayLimit);
        System.out.print("Location: " + location + " miles / 2500 miles (Currently in ");
        if (location < 200) {
            System.out.println("California, " + (200 - location) + " miles until Arizona)");
        }
        else if (location < 500) {
            System.out.println("Arizona, " + (500 - location) + " miles until New Mexico)");
        }
        else if (location < 800) {
            System.out.println("California, " + (800 - location) + " miles until Texas)");
        }
        else if (location < 1000) {
            System.out.println("California, " + (1000 - location) + " miles until Oklahoma)");
        }
        else if (location < 1500) {
            System.out.println("California, " + (1500 - location) + " miles until Kansas)");
        }
        else if (location < 1600) {
            System.out.println("California, " + (1600 - location) + " miles until Illinois)");
        }
        else {
            System.out.println("Illinois)");
        }
        System.out.println("Money: " + character.getMoney() + "$");
        System.out.println("Hunger: " + character.getHunger() + "%");
        System.out.println("Food: " + vehicle.getFood() + " (" + vehicle.getCapacity() + " max)");
        System.out.println("Gas: " + vehicle.getGas() + " gallons");
    } //todo: maybe have max tank size for each car?

    public void turn() {
        boolean done = false;
        while (!done) {
            System.out.println("What do you want to do today? (0 = Drive, 1 = Earn money, 2 = Shop, 3 = Get info on actions-doesn't take time)");
            int action = scan.nextInt();
            if (action == 0) { //drive
                int milesDriven = 0;
                while (vehicle.getGas() > 0 &&  milesDriven < 101-vehicle.getMileage()) {
                    vehicle.incrementGas(-1);
                    milesDriven += vehicle.getMileage();
                }
                if (vehicle.getGas() == 0) {
                    System.out.println("You drove " + milesDriven + " miles and ran out of gas");
                }//create new variable for car labeled "speed"- lambo travels 100/miles day,  
                //prius 60 miles/day that way each car has distinctive advantages and gameplay
                else {
                    System.out.println("You drove " + milesDriven + " miles");
                }
                location += milesDriven;
                done = true;
            }
            else if (action == 1) { //earn money
                System.out.println("How would you like to earn money? (0 = gamble, 1 = work, 2 = rob bank)");
                int choice = scan.nextInt(); 
                if (choice == 0) { //gamble
                    System.out.println("How much money would you like to put up? You have $"+character.getMoney()); 
                    int bet = scan.nextInt(); 
                    if(bet >= character.getMoney()){ 
                        System.out.println("You don't have that much, so you bet all your money");
                        bet = character.getMoney();
                    } 
                    if(Math.random() > 0.5){
                        character.incrementMoney(bet);; 
                        System.out.println("Congrats! You won $"+bet+" and now have $"+character.getMoney()); 
                    } 
                    else{ 
                        character.incrementMoney(-1*bet); 
                        System.out.println("Yikes! You lost $"+bet+" and now have $"+character.getMoney());
                   }
                }
                else if (choice == 1) { //work
                    int wageMade = (int) (50 * Math.random()) + 50; //you can make between 50 and 100 dollars, change if you want
                    System.out.println("You made $" + wageMade + "!");
                }
                else if (choice == 2) { //rob a bank
                    int randInt = (int) (100 * Math.random());
                    if (vehicle.getModel().equals("Lamborghini Aventador")) {
                        if (randInt < 50) {
                            System.out.println("Success! You made 1000$");
                            character.incrementMoney(1000);
                        }
                        else if (randInt < 75) {
                            int fine = (int) (900 * Math.random()) + 100;
                            System.out.println("You got caught. You were fined $" + fine);
                            character.incrementMoney(-1 * fine);
                        }
                        else {
                            System.out.println("You got caught and put in jail.");
                            arrested = true;
                        }
                    }
                    else if (vehicle.getModel().equals("Ford F150")) {
                        if (randInt < 30) {
                            System.out.println("Success! You made 1000$");
                            character.incrementMoney(1000);
                        }
                        else if (randInt < 70) {
                            int fine = (int) (900 * Math.random()) + 100;
                            System.out.println("You got caught. You were fined $" + fine);
                            character.incrementMoney(-1 * fine);
                        }
                        else {
                            System.out.println("You got caught and put in jail.");
                            arrested = true;
                        }
                    }
                    else if (vehicle.getModel().equals("Honda Civic")) {
                        if (randInt < 20) {
                            System.out.println("Success! You made 1000$");
                            character.incrementMoney(1000);
                        }
                        else if (randInt < 60) {
                            int fine = (int) (900 * Math.random()) + 100;
                            System.out.println("You got caught. You were fined $" + fine);
                            character.incrementMoney(-1 * fine);
                        }
                        else {
                            System.out.println("You got caught and put in jail.");
                            arrested = true;
                        }
                    }
                }
                done = true;
            }
            else if (action == 2) { //shop
                boolean doneShopping = false;
                while (!doneShopping) {
                    System.out.println("What would you like to buy? (0 = food, 1 = gas, 2 = exit)"); 
                    int choice = scan.nextInt(); 
                    if (choice == 0) { //buy food
                        System.out.println("You have $"+character.getMoney()+". Food costs $15/day and your "+vehicle.getModel()+" can store "+(vehicle.getCapacity()-vehicle.getFood())+" more days worth of food. \nHow many days of food would you like to buy?"); 
                        int amount = scan.nextInt();
                        if(amount * 15 >= character.getMoney()){  //trying to buy more than we can afford
                            amount = character.getMoney()/15;
                            System.out.println("You ran out of money and could only buy " + amount + " days worth of food");
                        }
                        if((amount + vehicle.getFood()) > vehicle.getCapacity()){ //trying to fit more food than we can
                            System.out.println("You couldn't fit the food in your car and wasted "+(amount+vehicle.getFood()-vehicle.getCapacity())+" days worth of food"); 
                            vehicle.setFood(vehicle.getCapacity()); 
                        }
                        else {
                            vehicle.incrementFood(amount);
                        }
                        character.incrementMoney(-15 * amount);
                        System.out.println("You spend $" + amount * 15 + ". You now have " + vehicle.getFood() + " days of food stored in your vehicle");
                    } 
                    if (choice == 1) {  // buy gas
                        System.out.println("You have $"+character.getMoney()+". Gas costs $5/gallon and your "+vehicle.getModel()+" needs " + (20 - vehicle.getGas()) + " gallons for a full tank. \nHow many gallons would you like to buy?"); 
                        int amount = scan.nextInt();
                        if(amount * 5 >= character.getMoney()){  //trying to buy more than we can afford
                            amount = character.getMoney()/5;
                            System.out.println("You ran out of money and could only buy " + amount + " gallons");
                        }
                        if((amount + vehicle.getFood()) > vehicle.getCapacity()){ //trying to fit more gas than we can
                            System.out.println("You overfilled and wasted " + (amount + vehicle.getGas()-20) + " gallons"); 
                            vehicle.setGas(20);
                        }
                        else {
                            vehicle.incrementGas(amount);
                        }
                        character.incrementMoney(-5 * amount);
                        System.out.println("You spend $" + amount * 5 + ". You now have " + vehicle.getGas() + " gallons of gas in your vehicle");
                    }
                    else if (choice == 2) {
                        doneShopping = true;
                    }
                }
                done = true;
            }
            else if (action == 3) { //get info
                System.out.println("What do you want to know about? (0 = Drive, 1 = Earn money, 2 = Shop)");
                int choice = scan.nextInt();
                if (choice == 0) {
                    System.out.println("You'll drive 100 miles or until your vehicle runs out of gas, each vehicle has a different mileage");
                }
                else if (choice == 1) {
                    System.out.println("Gamble: Bet a certain amount of money, 50% it'll get doubled and 50% it'll be lose");
                    System.out.println("Work: Make a random amount between $50 and $100");
                    System.out.println("Rob a bank: Either succeed and make $1000, fined an amount between $100-$1000, or arrested (lose). Chance of success depends on the vehicle (Lamborghini: 50%, Ford: 30%, Honda: 20%). Fine or arrested split evenly among remaining chance");
                }
                else if (choice == 2) {
                    System.out.println("Buy gas and food");
                }
            }
            else {
                System.out.println("That's not an option! You sat around all day and didn't do anything.");
            }
        }
        if (vehicle.getFood() > 0) { //if we have food in the car, eat food
            vehicle.incrementFood(-1);
        }
        else { //if not, we get hungrier
            character.incrementHunger(-10);
        }
        day++;
    }

    public void locationEvents() {
        if (location >= 200 && oldLocation < 100) {
            System.out.println("You're now in Arizona");
        }
        if (location >= 500 && oldLocation < 500) {
            System.out.println("You're now in New Mexico");
        }
        if (location >= 800 && oldLocation < 800) {
            System.out.println("You're now in Texas");
        }
        if (location >= 1000 && oldLocation < 1000) {
            System.out.println("You're now in Oklahoma");
        }
        if (location >= 1500 && oldLocation < 1500) {
            System.out.println("You're now in Kansas");
        }
        if (location >= 1600 && oldLocation < 1600) {
            System.out.println("You're now in Missouri");
        }
        if (location >= 2000 && oldLocation < 2000) {
            System.out.println("You're now in Illinois");
        }

        oldLocation = location;
    }

    public int checkGameOver() {
        if (character.getHunger() < 0) {
            return 1; //starved to death
        }
        else if (day > dayLimit) {
            return 2; //ran out of time
        }
        else if (arrested) {
            return 3;
        }
        else if (location > 2500) {
            return 4; //won
        }
        return 0; //game not over
    }

    public void printFinalStats() {

    }
}