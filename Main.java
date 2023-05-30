public class Main {
    public static void main (String[] args) {
        Game round = new Game();
        boolean gameOver = false;
        while (!gameOver) {
            round.printInfo();
            round.turn();
            gameOver = round.checkGameOver();
        }
        //round.gameOverMessage(); todo write this method in game
    }
}