package pieces;

import chess.Board;

import java.util.ArrayList;

public class Pawn extends Piece {
    private static Pawn whitePawn = new Pawn(Color.WHITE);
    private static Pawn blackPawn = new Pawn(Color.BLACK);

    private Pawn(Color color) {
        super(color);
    }

    public static Pawn createPawn(Color color) {
        return blackPawn.correctColorPawn(color);
    }

    private Pawn correctColorPawn(Color color) {
        switch (color) {
            case BLACK:
                return Pawn.blackPawn;
            default:
                return Pawn.whitePawn;
        }
    }

    public Pawn clone() {
        return correctColorPawn(this.color);
    }

    public ArrayList<Tile> possibleMoves(Board board, int x, int y){
        ArrayList<Tile> possibleMoves = new ArrayList<>();
        if (this.color == Color.WHITE && y == 1 && board.tile(x,3).empty()) {
            possibleMoves.add(board.tile(x,3));
        }
        else if (this.color == Color.BLACK && y == 6 && board.tile(x,4).empty()) {
            possibleMoves.add(board.tile(x,4));
        }
        if (this.color == Color.WHITE && y+1 <= 7) {
            if (board.tile(x,y+1).empty())
                possibleMoves.add(board.tile(x,y+1));
            if (x+1 <= 7 && !board.tile(x+1,y+1).empty() && board.tile(x+1,y+1).piece().color != this.color)
                possibleMoves.add(board.tile(x+1,y+1));
            if (x-1 >= 0 && !board.tile(x-1,y+1).empty() && board.tile(x-1,y+1).piece().color != this.color)
                possibleMoves.add(board.tile(x-1,y+1));
        }
        else if (y-1 >= 0){
            if (board.tile(x,y-1).empty())
                possibleMoves.add(board.tile(x,y-1));
            if (x+1 <= 7 && !board.tile(x+1,y-1).empty() && board.tile(x+1,y-1).piece().color != this.color)
                possibleMoves.add(board.tile(x+1,y-1));
            if (x-1 >= 0 && !board.tile(x-1,y-1).empty() && board.tile(x-1,y-1).piece().color != this.color)
                possibleMoves.add(board.tile(x-1,y-1));
        }
        return possibleMoves;
    }

    @Override
    public int value() {
        return 0;
    }

    public String toString() {
        if (this.color == Color.WHITE)
           return "\u265F";
        else
            return "\u2659";
    }
}