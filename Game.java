import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Game implements Serializable{
    private static final long serialVersionUID = 1L;
    private Person character;
    private Car vehicle;
    private int oldLocation;
    private int location;
    private int day;
    private int dayLimit;
    private boolean arrested;
    private HashMap <String, Boolean> ynKey = new HashMap <String, Boolean>();
    Scanner scan = new Scanner(System.in);
    public Game() {
        //asks for values for character, car, settings
        System.out.println("Welcome to Route 66!");//todo: write intro

        System.out.println("Choose your difficulty: (0 = easy, 1 = medium, 2 = hard)");
        int difficulty = scan.nextInt();

        System.out.println("Name your character:");
        String name = scan.nextLine();

        System.out.println("Choose your car: (0 = Lamborghini Aventador, 1 = Ford F150, 2 = Honda Civic)"); //todo: add info about cars
        int carId = scan.nextInt();

        //inits variables
        character = new Person(name, difficulty);
        vehicle = new Car(carId);
        oldLocation = 0;
        location = 0; 
        day = 1;
        arrested = false;
        if (difficulty == 2) {
            dayLimit = 35;
        }
        else if (difficulty == 1) {
            dayLimit = 45;
        }
        else {
            dayLimit = 50;
        }
        ynKey.put("y", true);
        ynKey.put("n", false);
        ynKey.put("yes", true);
        ynKey.put("no", false);
    }
    
    public void doRandomEvent(){ 
        double a = Math.random(); 
        if (a < 0.001) {
            System.out.println("You won the lottery! Money increased by $1,000,000");
            character.incrementMoney(1000000);
        }
        else if (a < 0.05) { 
            System.out.println("Oh no! Somebody siphoned all your gas and stole your food. Food and Gas to 0"); 
            vehicle.setFood(0); 
            vehicle.setGas(0); 
        }
        else if (a < 0.15) {
            if (vehicle.getFood() >= 1) {
                System.out.println("A hitchhiker asks you for a day of food. He tells you that he'll pay you 10$. Do you accept? (y/n)");
                String accept = scan.next();
                boolean hitchhikerGood = (int) (2 * Math.random()) == 0;
                if (ynKey.get(accept.toLowerCase())) {
                    if (hitchhikerGood) {
                        int amtPaid = (int) (15 * Math.random()) + 5;
                        vehicle.incrementFood(-1);
                        character.incrementMoney(amtPaid);
                        System.out.println("The hitchhiker thanks you, and actually pays you $" + amtPaid + ". You now have " + vehicle.getFood() + " days of food and $" + character.getMoney());
                    }
                    else {
                        vehicle.incrementFood(-1);
                        System.out.println("The hitchhiker runs away once you give the food to him. You now have " + vehicle.getFood() + " days of food");
                    }
                }
                else {
                    if (hitchhikerGood) {
                        System.out.println("The hitchhiker leaves.");
                    }
                    else {
                        vehicle.incrementFood(-1);
                        System.out.println("The hitchhiker takes your food anyways. You now have " + vehicle.getFood() + " days of food");
                    }
                }
            }
        }
        else if (a < 0.25) {
            int moneyFound = (int) (20 * Math.random()) + 1;
            character.incrementMoney(moneyFound);
            System.out.println("You found $" + moneyFound + " randomly! You now have $" + character.getMoney());
        }
        else if (a < 0.3) {
            if (character.getMoney() >= 100) {
                character.incrementMoney(-100);
                System.out.println("Your car broke down. You spend 100$ to fix it. You now have $" + character.getMoney());
            }
        }
        else if (a < 0.4) {
            if (character.getHealth() > 0.5) {
                character.incrementHealth(-30);
                System.out.println("You get a cold. Your health goes down 30% from the energy you use to fight it off. Your health is now " + character.getHealth() + "%");
            }
        } 
        else if(a < 0.45){ 
            location += 100;
            System.out.println("A tow truck driver says that he pities your "+vehicle.getModel()+". He tows you for 100 miles. You are now at " + location + " miles"); 
        } 
        else if (a < 0.5){ 
            System.out.println("An urban witch offers you a mysterious looking juice. Do you take it? (y/n)"); 
                String accept = scan.next();
                boolean witchGood = (int) (4 * Math.random()) != 0;
                if (ynKey.get(accept.toLowerCase())) {
                    if (witchGood) {
                        vehicle.setFood(vehicle.getCapacity());
                        character.setHealth(100);
                        System.out.println("The juice tasted a little funny but you suddenly feel full and in great health. Food and health to 100%" );
                    }
                    else {
                        character.setHealth(-10);
                        System.out.println("The juice helps you grow wings and you fly away to heaven. You die instantly.");
                    }
                }
                else {
                    if (witchGood) {
                        character.incrementMoney(100);
                        System.out.println("The witch reveals herself to be part of a comedy prank show and gives you $100. You now have $" + character.getMoney()); 
                    }
                    else {
                        System.out.println("The witch tells you that the juice was actually poison. Close call.");
                    } 
                } 
            }
        }
    

    public void printInfo() {
        System.out.println("DAY " + day + " / " + dayLimit);
        System.out.print("Location: " + location + " miles / 2500 miles (Currently in ");
        if (location < 200) {
            System.out.println("California, " + (200 - location) + " miles until Arizona)");
        }
        else if (location < 500) {
            System.out.println("Arizona, " + (500 - location) + " miles until New Mexico)");
        }
        else if (location < 800) {
            System.out.println("New Mexico, " + (800 - location) + " miles until Texas)");
        }
        else if (location < 1000) {
            System.out.println("Texas, " + (1000 - location) + " miles until Oklahoma)");
        }
        else if (location < 1500) {
            System.out.println("Oklahoma, " + (1500 - location) + " miles until Kansas)");
        }
        else if (location < 1600) {
            System.out.println("Kansas, " + (1600 - location) + " miles until Illinois)");
        }
        else {
            System.out.println("Illinois)");
        }
        System.out.println("Money: " + character.getMoney() + "$");
        System.out.println("Health: " + character.getHealth() + "%");
        System.out.println("Food: " + vehicle.getFood() + " (" + vehicle.getCapacity() + " max)");
        System.out.println("Gas: " + vehicle.getGas() + " gallons");
    } //todo: maybe have max tank size for each car?

    public void turn() {
        boolean done = false;
        while (!done) {
            int action = 0;
            Boolean gotOption = false;
            System.out.println("What do you want to do today? (0 = Drive, 1 = Earn money, 2 = Shop, 3 = Get info on actions-doesn't take time)");
            while (!gotOption) {
                try {
                    String actionString = scan.nextLine();
                    action = Integer.parseInt(actionString);
                    if (action <= 3 && action >= 0) {
                        gotOption = true;
                    }
                }
                catch(Exception e) {}
            }
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
                    character.incrementMoney(wageMade);
                }
                else if (choice == 2) { //rob a bank
                    int randInt = (int) (100 * Math.random());
                    if (vehicle.getModel().equals("Lamborghini Aventador")) {
                        if (randInt < 50) {
                            System.out.println("Success! You made 1000$");
                            character.incrementMoney(1000);
                        }
                        else if (randInt < 75) {
                            int fine;
                            fine = (int) (Math.random() * (character.getMoney() - 100)) + 100;
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
                            int fine;
                            fine = (int) (Math.random() * (character.getMoney() - 100)) + 100;
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
                            int fine;
                            fine = (int) (Math.random() * (character.getMoney() - 100)) + 100;
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
                        if((amount + vehicle.getGas()) > 20){ //trying to fit more gas than we can

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
                
            }
            else if (action == 3) { //get info
                System.out.println("What do you want to know about? (0 = Drive, 1 = Earn money, 2 = Shop, 3 = Food, health, and money)");
                int choice = scan.nextInt();
                if (choice == 0) {
                    System.out.println("You'll drive 100 miles or until your vehicle runs out of gas, each vehicle has a different mileage");
                }
                else if (choice == 1) {
                    System.out.println("Gamble: Bet a certain amount of money, 50% it'll get doubled and 50% it'll be lose");
                    System.out.println("Work: Make a random amount between $50 and $100");
                    System.out.println("Rob a bank: Either succeed and make $1000, fined an amount between $100 to all your money, or arrested (lose). Chance of success depends on the vehicle (Lamborghini: 50%, Ford: 30%, Honda: 20%). Fine or arrested split evenly among remaining chance");
                }
                else if (choice == 2) {
                    System.out.println("Buy gas and food");
                }
                else if (choice == 3) {
                    System.out.println("Every day, you attempt to eat one day's worth of food. If you don't have that, your health decreases 10%. Your health can also decrease from other factors. If your health reaches 0, you die. If you eat food with a health bar of less than 100%, your health will increase by 10%. As for money, you can spend until you are in debt. If you are in debt, not only can you not buy more things, but you have a chance of being arrested by the IRS everyday.");
                }
            }
        }
        if (vehicle.getFood() > 0) { //if we have food in the car, eat food
            vehicle.incrementFood(-1);
            if (character.getHealth() <= 90) {
                character.incrementHealth(10); //you also refill your health bar if it was low
            } 
        }
        else { //if not, health gets worse
            character.incrementHealth(-10);
        }
        if (character.getMoney() < 0) {
            if(Math.random() > 0.5){
            System.out.println("The IRS found out you were bankrupt and arrested you."); 
            arrested = true; 
            }
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
        if (character.getHealth() < 0) {
            return 1; //died
        }
        else if (day > dayLimit) {
            return 2; //ran out of time
        }
        else if (arrested) {
            return 3;
        }
        else if (location >= 2500) {
            return 4; //won
        }
        return 0; //game not over
    } 

    public void printFinalStats(int i) {
        switch (i) {
            case 1:
                System.out.print("Game over: You died");
                break;
            case 2:
                System.out.println("Game over: You didn't reach the destination in " + dayLimit + " days");
                break;
            case 3:
                System.out.println("Game over: You got arrested");
                break;
            case 4:
                System.out.println("Congrats, "+character.getName()+"! You completed all of Route 66 in " + day + " days");
                break;
        }
        if (i != 4) {
            System.out.println("You made it " + location + " miles");
        }
    }  
}