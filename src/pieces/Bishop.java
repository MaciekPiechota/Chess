package pieces;

import chess.Board;

import java.util.ArrayList;

public class Bishop extends Piece {
    private static Bishop whiteBishop = new Bishop(Color.WHITE);
    private static Bishop blackBishop = new Bishop(Color.BLACK);

    private static int[][] table = {
            {-20, -10, -10, -10, -10, -10, -10, -20},
            {-10, 0, 0, 0, 0, 0, 0, -10},
            {-10, 0, 5, 10, 10, 5, 0, -10},
            {-10, 5, 5, 10, 10, 5, 5, -10},
            {-10, 0, 10, 10, 10, 10, 0, -10},
            {-10, 10, 10, 10, 10, 10, 10, -10},
            {-10, 5, 0, 0, 0, 0, 5, -10},
            {-20, -10, -10, -10, -10, -10, -10, -20}};

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
    public int value(int x, int y, boolean midGame) {
        if (this.color == Color.WHITE)
            return 30 * table[x][y];
        return 30 * table[x][7-y];
    }

    public String toString() {
        return this.color == Color.BLACK ? "\u2657" : "\u265D";
    }
}
