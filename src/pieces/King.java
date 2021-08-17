package pieces;

import chess.Board;

import java.util.ArrayList;

public class King extends Piece {
    private static King whiteKing = new King(Color.WHITE);
    private static King blackKing = new King(Color.BLACK);

    private static int[][] middleTable = {
            {-30, -40, -40, -50, -50, -40, -40, -30},
            {-30, -40, -40, -50, -50, -40, -40, -30},
            {-30, -40, -40, -50, -50, -40, -40, -30},
            {-30, -40, -40, -50, -50, -40, -40, -30},
            {-20, -30, -30, -40, -40, -30, -30, -20},
            {-10, -20, -20, -20, -20, -20, -20, -10},
            {20, 20, 0, 0, 0, 0, 20, 20},
            {20, 30, 10, 0, 0, 10, 30, 20}};

    private static int[][] endTable = {
            {-50, -40, -30, -20, -20, -30, -40, -50},
            {-30, -20, -10, 0, 0, -10, -20, -30},
            {-30, -10, 20, 30, 30, 20, -10, -30},
            {-30, -10, 30, 40, 40, 30, -10, -30},
            {-30, -10, 30, 40, 40, 30, -10, -30},
            {-30, -10, 20, 30, 30, 20, -10, -30},
            {-30, -30, 0, 0, 0, 0, -30, -30},
            {-50, -30, -30, -30, -30, -30, -30, -50}};

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
    public int value(int x, int y, boolean midGame) {
        if (this.color == Color.WHITE) {
            if (midGame)
                return 900 * middleTable[x][y];
            return 900 * endTable[x][y];
        } else {
            if (midGame)
                return 900 * middleTable[x][7 - y];
            return 900 * endTable[x][7 - y];
        }
    }


    public String toString() {
        return this.color == Color.WHITE ? "\u265A" : "\u2654";
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
