package pieces;

public class Tile {
    private Piece piece;
    private boolean czyPuste;
    private int x;
    private int y;

    public Tile(Piece piece, int x, int y) {
        this.piece = piece;
        this.czyPuste = false;
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.czyPuste = true;
    }

    public boolean empty() {
        return czyPuste;
    }

    public void setCzyPuste(boolean czyPuste) {
        this.czyPuste = czyPuste;
    }

    public void setBierka(Piece piece) {
        this.piece = piece;
    }

    public Piece piece() {
        return this.piece;
    }

    @Override
    public String toString() {
        return "";
    }

    public void setPuste(boolean puste) {
        this.czyPuste = puste;
    }

    public void setBierek(Piece piece) {
        this.piece = piece;
    }

    public int x() {return this.x;}

    public int y() {return this.y;}

    public void usunBierek() {
        if (!this.czyPuste)
            this.piece = null;
    }

}