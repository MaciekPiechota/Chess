package pieces;

import chess.Board;

import java.util.ArrayList;

public abstract class Piece {
    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract ArrayList<Tile> possibleMoves(Board board,
                                                  int x, int y);

    public abstract int value();

    public abstract Piece clone();

    public Color kolor() {
        return this.color;
    }

    protected ArrayList<Tile> horizontalVerical(Board board, int x, int y, Color color) {
        ArrayList<Tile> mozliweRuchy = new ArrayList<>();
        //poziomo w prawo
        int i = x + 1;
        while (i < 8 && board.tile(i, y).empty()) {
            mozliweRuchy.add(board.tile(i, y));
            i++;
        }
        if (i < 8 && board.tile(i,y).piece().color != color)
            mozliweRuchy.add(board.tile(i, y));

        //poziomo w lewo
        i = x - 1;
        while (i >= 0 && board.tile(i, y).empty()) {
            mozliweRuchy.add(board.tile(i, y));
            i--;
        }
        if (i >= 0 && board.tile(i,y).piece().color != color)
            mozliweRuchy.add(board.tile(i, y));

        //pionowo w gore
        i = y + 1;
        while (i < 8 && board.tile(x, i).empty()) {
            mozliweRuchy.add(board.tile(x, i));
            i++;
        }
        if (i < 8 && board.tile(x,i).piece().color != color)
            mozliweRuchy.add(board.tile(x, i));
        // pionowo w dol
        i = y - 1;
        while (i >= 0 && board.tile(x, i).empty()) {
            mozliweRuchy.add(board.tile(x, i));
            i--;
        }
        if (i >= 0 && board.tile(x,i).piece().color != color)
            mozliweRuchy.add(board.tile(x, i));
        return mozliweRuchy;
    }

    protected ArrayList<Tile> diagonal(Board board, int x, int y, Color color) {
        ArrayList<Tile> mozliweRuchy = new ArrayList<>();
        // polnoc wschod
        int dx = 1;
        int dy = 1;
        int x1 = x + dx;
        int y1 = y + dy;

        while (x1 < 8 && y1 < 8 && board.tile(x1,y1).empty()){
            mozliweRuchy.add(board.tile(x1,y1));
            x1 += dx;
            y1 += dy;
        }
        if (x1 < 8 && y1 < 8 && board.tile(x1,y1).piece().color != color)
            mozliweRuchy.add(board.tile(x1,y1));

        // polnoc zachow
        dx = -1;
        dy = 1;
        x1 = x + dx;
        y1 = y + dy;

        while (x1 >= 0 && y1 < 8 && board.tile(x1,y1).empty()){
            mozliweRuchy.add(board.tile(x1,y1));
            x1 += dx;
            y1 += dy;
        }
        if (x1 >= 0 && y1 < 8 && board.tile(x1,y1).piece().color != color)
            mozliweRuchy.add(board.tile(x1,y1));

        // polodnie zachow
        dx = -1;
        dy = -1;
        x1 = x + dx;
        y1 = y + dy;

        while (x1 >= 0 && y1 >= 0 && board.tile(x1,y1).empty()){
            mozliweRuchy.add(board.tile(x1,y1));
            x1 += dx;
            y1 += dy;
        }
        if (x1 >= 0 && y1 >= 0 && board.tile(x1,y1).piece().color != color)
            mozliweRuchy.add(board.tile(x1,y1));

        // polodnie wschod
        dx = 1;
        dy = -1;
        x1 = x + dx;
        y1 = y + dy;

        while (x1 < 8&& y1 >= 0 && board.tile(x1,y1).empty()){
            mozliweRuchy.add(board.tile(x1,y1));
            x1 += dx;
            y1 += dy;
        }
        if (x1 < 8 && y1 >= 0 && board.tile(x1,y1).piece().color != color)
            mozliweRuchy.add(board.tile(x1,y1));

        return mozliweRuchy;
    }

    public boolean isKing() {
        return false;
    }

}
