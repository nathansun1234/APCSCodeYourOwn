import java.util.*;
public class Game {
    private Person player;
    private int location;
    private int day;
    private int dayLimit; 

    public Game(Person player, int difficulty) {
        this.player = player;
        day = 0;
        location = 0;
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
        int task;
        System.out.println("Day " + day);
        System.out.println("What do you want to do today? (0 = Drive, 1 = Earn money, 2 = Shop)");
        task = scan.nextInt();


    }
}