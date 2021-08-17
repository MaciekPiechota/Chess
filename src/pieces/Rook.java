package pieces;

import chess.Board;

import java.util.ArrayList;

public class Rook extends Piece {
    private static Rook whiteRook = new Rook(Color.WHITE);
    private static Rook blackRook = new Rook(Color.BLACK);

    private static int[] table = {
            -20,-10,-10,-10,-10,-10,-10,-20,
            -10,  0,  0,  0,  0,  0,  0,-10,
            -10,  0,  5, 10, 10,  5,  0,-10,
            -10,  5,  5, 10, 10,  5,  5,-10,
            -10,  0, 10, 10, 10, 10,  0,-10,
            -10, 10, 10, 10, 10, 10, 10,-10,
            -10,  5,  0,  0,  0,  0,  5,-10,
            -20,-10,-10,-10,-10,-10,-10,-20,};

    private Rook(Color color) {
        super(color);
    }

    public static Rook createRook(Color color) {
        return blackRook.correctColorRook(color);
    }

    public Rook clone() {
        return correctColorRook(this.color);
    }

    private Rook correctColorRook(Color color) {
        switch (color) {
            case BLACK:
                return Rook.blackRook;
            default:
                return Rook.whiteRook;
        }
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y) {
        ArrayList<Tile> mozliweRuchy = horizontalVerical(board,x,y,this.color);
        return  mozliweRuchy;
    }

    @Override
    public int value(int x, int y, boolean midGame) {
        if (this.color == Color.WHITE)
            return 50*table[y*8+x];
        return 50*table[(7-y)*8+x];
    }

    public String toString() {
        return this.color == Color.WHITE ? "\u265C" : "\u2656";
    }
}
