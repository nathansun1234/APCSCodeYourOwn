public class Main {
    public static void main (String[] args) {
        Game round = new Game();
        System.out.println("");
        int gameOver = 0;
        while (gameOver == 0) {
            round.printInfo();
            round.turn();
            round.locationEvents();
            gameOver = round.checkGameOver();
            System.out.println("");
        }
        if (gameOver == 1) {

        }
        else if (gameOver == 2) {

        }
        
    }
}