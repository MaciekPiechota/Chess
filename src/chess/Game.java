package chess;

import pieces.Color;
import players.Player;

public class Game {
    private Player[] players;

    public Game(Player player1, Player player2) {
        this.players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        Player.setSzachownica(new chess.Board());
        System.out.println(players[0].boardString());
    }

    /**
     * Rozpoczyna grę pomiędzy dwoma graczami przekazanymi w konstruktorze
     */
    public void startGame() {

        int round = 0;
        int movingPlayer;
        if (this.players[0].color() == Color.WHITE)
            movingPlayer = 0;
        else
            movingPlayer = 1;

        while(this.players[movingPlayer].makeMove()) {
            System.out.println(players[movingPlayer].boardString());
            System.out.println("----------");
            System.out.println("Round: "+round);
            round++;
            if (movingPlayer == 0)
                movingPlayer = 1;
            else
                movingPlayer = 0;
        }
    }

}
