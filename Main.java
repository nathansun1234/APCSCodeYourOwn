public class Main {
    public static void main (String[] args) {
        Game round = new Game();
        round.printInfo();
        System.out.println("");
        round.turn();
        System.out.println("");
        round.printInfo();
        System.out.println("");
        round.turn();
    }
}