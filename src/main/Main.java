package main;
        import chess.Game;
        import pieces.Color;
        import players.Player;
        import players.RadnomPlayer;

public class Main {

    static void radnomTest() {
        Player random1 = new RadnomPlayer(Color.WHITE);
        Player random2 = new RadnomPlayer(Color.BLACK);
        Game chess = new Game(random1,random2);
        chess.startGame();
    }


    public static void main(String[] args) {
        // write your code here
    }

}
