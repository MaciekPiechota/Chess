package pieces;

import chess.Board;

import java.util.ArrayList;

public class Queen extends Piece {
    private static Queen whiteQueen = new Queen(Color.WHITE);
    private static Queen blackQueen = new Queen(Color.BLACK);

    private Queen(Color color) {
        super(color);
    }

    public static Queen createQueen(Color color) {
        return blackQueen.correctColorQueen(color);
    }

    public Queen clone() {
        return correctColorQueen(this.color);
    }

    private Queen correctColorQueen(Color color) {
        switch (color) {
            case BLACK:
                return Queen.blackQueen;
            default:
                return Queen.whiteQueen;
        }
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y) {
        ArrayList<Tile> mozliweRuchy = diagonal(board,x,y,this.color);
        mozliweRuchy.addAll(horizontalVerical(board,x,y,this.color));
        return mozliweRuchy;
    }

    @Override
    public int value() {
        return 0;
    }

    public String toString() {
        return this.color == Color.WHITE ? "\u265B":"\u2655";
    }
}
