package pieces;

import chess.Board;

import java.util.ArrayList;

public class Rook extends Piece {
    private static Rook whiteRook = new Rook(Color.WHITE);
    private static Rook blackRook = new Rook(Color.BLACK);

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
    public int value() {
        return 0;
    }

    public String toString() {
        return this.color == Color.WHITE ? "\u265C" : "\u2656";
    }
}
