package players;

import chess.Board;
import pieces.Color;

public abstract class Player {
    protected static Board board;
    protected Color playerColor;

    public Player(Color colorGracza) {
        this.playerColor = colorGracza;
    }

    public static void setSzachownica(Board board) {
        Player.board = board;
    }

    /**
     * Wykonuje ruch na planszy trzymanej jako protected wartosc Gracza
     * Zwraca true gdy jest możliwosć wykonania ruchy i false w przeciwnym wypadku
     * @return
     */
    public abstract boolean makeMove();

    public String boardString() {
        return Player.board.toString();
    }

    public Color color() {
        return this.playerColor;
    }
}
