public class Main {
    public static void main (String[] args) {
        Game round = new Game();
        System.out.println("");
        int gameOver = 0;
        while (gameOver == 0) {
            round.printInfo();
            System.out.println("");
            round.doRandomEvent();
            System.out.println("");
            gameOver = round.checkGameOver(); 
            if (gameOver != 0) { //in case the random event ends the game
                break;
            }
            round.turn();
            System.out.println("");
            round.locationEvents();
            System.out.println("");
            gameOver = round.checkGameOver(); 
        }
        round.printFinalStats(gameOver);
    }
}