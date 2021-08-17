package pieces;

import chess.Board;

import java.util.ArrayList;

public class Bishop extends Piece {
    private static Bishop whiteBishop = new Bishop(Color.WHITE);
    private static Bishop blackBishop = new Bishop(Color.BLACK);

    private Bishop(Color color) {
        super(color);
    }

    private Bishop correctColorBishop(Color color) {
        switch (color) {
            case BLACK:
                return Bishop.blackBishop;
            default:
                return Bishop.whiteBishop;
        }
    }

    public static Bishop createBishop(Color color) {
        return whiteBishop.correctColorBishop(color);
    }

    public Bishop clone() {
        return correctColorBishop(this.color);
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = diagonal(board, x, y, this.color);
        return possibleMoves;
    }

    @Override
    public int value() {
        return 0;
    }

    public String toString() {
        return this.color == Color.BLACK ? "\u2657" : "\u265D";
    }
}
