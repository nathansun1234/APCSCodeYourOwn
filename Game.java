import java.util.*;
public class Game {
    private Person character;
    private Car vehicle;
    private int location;
    private int day;
    private int dayLimit; 

    public Game() {
        //asks for values for character, car, settings
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Route 66!");//todo: write intro

        System.out.println("Choose your difficulty: (0 = easy, 1 = medium, 2 = hard)");
        int difficulty = scan.nextInt();

        System.out.println("Name your character:");
        String name = scan.next();

        System.out.println("Choose your car: (0 = Lamborghini Aventador, 1 = Ford F150, 2 = Honda Civic)"); //todo: add info about cars
        int carId = scan.nextInt();

        //inits variables
        character = new Person(name);
        vehicle = new Car(carId);
        location = 0;
        day = 0;
        if (difficulty == 0) {
            dayLimit = 40;
        }
        else if (difficulty == 1) {
            dayLimit = 30;
        }
        else if (difficulty == 2) {
            dayLimit = 25;
        }//Day limit more similar 25-30-40...change RNG?
    }
    public void printInfo() {
        System.out.println("Day " + day + " / " + dayLimit);
        System.out.println("Location: " + location + "mi / 2500mi");
        System.out.println("Money: " + character.getMoney() + "$");
        System.out.println("Hunger: " + character.getHunger() + "%");
        System.out.println("Food: " + vehicle.getFood() + " (" + vehicle.getCapacity() + " max)");
        System.out.println("Gas: " + vehicle.getGas() + " gallons");
    }//have max tank size

    public void turn() {
        boolean done = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do today? (0 = Drive, 1 = Earn money, 2 = Shop)");
        while (!done) {
            int action = scan.nextInt();
            if (action == 0) {
                int milesDriven = 0;
                while (vehicle.getGas() > 0 &&  milesDriven < 101-vehicle.getMileage()) {
                    vehicle.decreaseGas(1);
                    milesDriven += vehicle.getMileage();
                }
                if (vehicle.getGas() == 0) {
                    System.out.println("You drove " + milesDriven + "miles and ran out of gas");
                }//create new variable for car labeled "speed"- lambo travels 100/miles day,  
                //prius 60 miles/day that way each car has distinctive advantages and gameplay
                else {
                    System.out.println("You drove " + milesDriven + " miles");
                }
                location += milesDriven;
                done = true;
            }
            else if (action == 1) {  
                System.out.println("How would you like to earn money? (0 = trade, 1 = gamble, 2 = work, 3 = rob bank)");
                int choice = scan.nextInt(); 


            }
            else if (action == 2) {

            }
            day++;
            if (vehicle.getFood() > 0) {
                vehicle.decreaseFood(1);
            }
            else {
                character.incrementHunger(-10);
            }
        }
    }

    public boolean checkGameOver() {
        return true; //todo: write method
    }
}