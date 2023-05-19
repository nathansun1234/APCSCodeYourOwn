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

        System.out.println("Choose your c0ar: (0 = Lamborghini Aventador, 1 = Ford F150, 2 = Honda Civic)"); //todo: add info about cars
        int carId = scan.nextInt();

        //inits variables
        character = new Person(name);
        vehicle = new Car(carId);
        location = 0;
        day = 0;
        if (difficulty == 0) {
            dayLimit = 100;
        }
        else if (difficulty == 1) {
            dayLimit = 50;
        }
        else if (difficulty == 2) {
            dayLimit = 25;
        }
    }

    public void turn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Day " + day);
        System.out.println("What do you want to do today? (0 = Drive, 1 = Earn money, 2 = Shop)");
        int action = scan.nextInt();
        if (action == 0) {

        }
        else if (action == 1) {

        }
        else if (action == 2) {
            
        }


    }
}