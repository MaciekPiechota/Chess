package pieces;

import chess.Board;

import java.util.ArrayList;

public class Knight extends Piece {
    private static Knight whiteKnight = new Knight(Color.WHITE);
    private static Knight blackKnight = new Knight(Color.BLACK);

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
    public int value() {
        return 0;
    }

    public String toString() {
        return this.color == Color.BLACK ? "\u2658" : "\u265E";
    }
}
