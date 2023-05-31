public class Main {
    public static void main (String[] args) {
        Game round = new Game();
        int gameOver = 0;
        while (gameOver == 0) {
            round.printInfo();
            round.turn();
            gameOver = round.checkGameOver();
        }
        if (gameOver == 1) {

        }
        else if (gameOver == 2) {
            
        }
        
    }
}