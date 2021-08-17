package pieces;

import chess.Board;

import java.util.ArrayList;

public class King extends Piece {
    private static King whiteKing = new King(Color.WHITE);
    private static King blackKing = new King(Color.BLACK);

    private King(Color color) {
        super(color);
    }

    private King correctColorKing(Color color) {
        switch (color) {
            case BLACK:
                return King.blackKing;
            default:
                return King.whiteKing;
        }
    }

    public static King createKing(Color color) {
        return blackKing.correctColorKing(color);
    }

    public King clone() {
        return correctColorKing(this.color);
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = new ArrayList<>();
        if (x + 1 <= 7 && (board.tile(x + 1, y).empty() || board.tile(x + 1, y).piece().color != this.color))
            possibleMoves.add(board.tile(x + 1, y));
        if (x - 1 >= 0 && (board.tile(x - 1, y).empty() || board.tile(x - 1, y).piece().color != this.color))
            possibleMoves.add(board.tile(x - 1, y));
        if (y + 1 <= 7 && (board.tile(x, y + 1).empty() || board.tile(x, y + 1).piece().color != this.color))
            possibleMoves.add(board.tile(x, y + 1));
        if (y - 1 >= 0 && (board.tile(x, y - 1).empty() || board.tile(x, y - 1).piece().color != this.color))
            possibleMoves.add(board.tile(x, y - 1));
        return possibleMoves;
    }

    @Override
    public int value() {
        return 0;
    }


    public String toString() {
        return this.color == Color.WHITE ? "\u265A" : "\u2654";
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
