package pieces;

import chess.Board;

import java.util.ArrayList;

public class Knight extends Piece {
    private static Knight whiteKnight = new Knight(Color.WHITE);
    private static Knight blackKnight = new Knight(Color.BLACK);

    private static int[] table = {
            -50,-40,-30,-30,-30,-30,-40,-50,
            -40,-20,  0,  0,  0,  0,-20,-40,
            -30,  0, 10, 15, 15, 10,  0,-30,
            -30,  5, 15, 20, 20, 15,  5,-30,
            -30,  0, 15, 20, 20, 15,  0,-30,
            -30,  5, 10, 15, 15, 10,  5,-30,
            -40,-20,  0,  5,  5,  0,-20,-40,
            -50,-40,-30,-30,-30,-30,-40,-50,};

    private Knight(Color color) {
        super(color);
    }

    private Knight correctColorKnight(Color color) {
        switch (color) {
            case BLACK:
                return Knight.blackKnight;
            default:
                return Knight.whiteKnight;
        }
    }

    public static Knight createKnight(Color color) {
        return blackKnight.correctColorKnight(color);
    }

    public Knight clone() {
        return correctColorKnight(this.color);
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = new ArrayList<>();
        //pionowo
        return  possibleMoves;
    }

    @Override
    public int value(int x, int y, boolean midGame) {
        if (this.color == Color.WHITE)
            return 30*table[8*y+x];
        else
            return 30*table[8*(7-y)+x];
    }

    public String toString() {
        return this.color == Color.BLACK ? "\u2658" : "\u265E";
    }
}
