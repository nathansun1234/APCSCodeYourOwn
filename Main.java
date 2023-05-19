import java.util.*;
public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        //Starts game
        System.out.println("Welcome to Route 66!");//todo: write intro
        System.out.println("Choose your difficulty: (0 = easy, 1 = medium, 2 = hard)");
        int difficulty = scan.nextInt();
        System.out.println("Name your character:");
        String name = scan.nextLine();
        int car = 3;
        while (car == 3) {
            System.out.println("Choose your car: (0 = Lamborghini Aventador, 1 = Ford F150, 2 = Honda Civic, 3 = Look at car's stats)");
            car = scan.nextInt();
            if (car == 3) {
                System.out.println("Here is the info about the cars:"); //todo: write info
            }
        }

    }
}