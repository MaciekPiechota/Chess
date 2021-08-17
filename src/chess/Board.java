package chess;

import pieces.*;

import java.util.ArrayList;

import static pieces.Color.WHITE;

public class Board {
    private Tile[][] pola;
    protected Color martwyKrol = null;

    public Board() {

        this.pola = new Tile[8][8];

        for (int i = 0; i < 8; i++) {
            this.pola[i][1] = new Tile(Pawn.createPawn(WHITE),i,1);
            this.pola[i][6] = new Tile(Pawn.createPawn(Color.BLACK),i,6);
            this.pola[i][2] = new Tile(i,2);
            this.pola[i][3] = new Tile(i,3);
            this.pola[i][4] = new Tile(i,4);
            this.pola[i][5] = new Tile(i,5);
        }
        for (int i = 1; i < 7; i++) {
            this.pola[i][0] = new Tile(i,0);
            this.pola[i][7] = new Tile(i,7);
        }
        this.pola[0][0] = new Tile(Rook.createRook(WHITE),0,0);
        this.pola[1][0] = new Tile(Knight.createKnight(WHITE),1,0);
        this.pola[2][0] = new Tile(Bishop.createBishop(WHITE),2,0);
        this.pola[7][0] = new Tile(Rook.createRook(WHITE),7,0);
        this.pola[6][0] = new Tile(Knight.createKnight(WHITE),6,0);
        this.pola[5][0] = new Tile(Bishop.createBishop(WHITE),5,0);

        this.pola[0][7] = new Tile(Rook.createRook(Color.BLACK),0,7);
        this.pola[2][7] = new Tile(Bishop.createBishop(Color.BLACK),2,7);
        this.pola[1][7] = new Tile(Knight.createKnight(Color.BLACK),1,7);
        this.pola[7][7] = new Tile(Rook.createRook(Color.BLACK),7,7);
        this.pola[5][7] = new Tile(Bishop.createBishop(Color.BLACK),5,7);
        this.pola[6][7] = new Tile(Knight.createKnight(Color.BLACK),6,7);


        this.pola[4][0] = new Tile(Queen.createQueen(WHITE),4,0);
        this.pola[3][7] = new Tile(Queen.createQueen(Color.BLACK),3,7);
        this.pola[3][0] = new Tile(King.createKing(WHITE),3,0);
        this.pola[4][7] = new Tile(King.createKing(Color.BLACK),4,7);

    }

    public Board(Tile[][] board) {
        this.pola = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].empty())
                    this.pola[i][j] = new Tile(i,j);
                else
                    this.pola[i][j] = new Tile(board[i][j].piece().clone(),i,j);
            }
        }
    }

    public ArrayList<Tile> bierki(Color color) {
        ArrayList<Tile> bierki = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!this.pola[i][j].empty()) {
                    if (this.pola[i][j].piece().kolor() == color) {
                        bierki.add(this.pola[i][j]);
                    }
                }
            }
        }
        return bierki;
    }

    public String toString () {
        StringBuilder wynik = new StringBuilder("");
        wynik.append("\n");

        char blackBox = '\u25A0';
        char whiteBox = '\u25A1';
        for (int y = 0; y < 8; y++) {
            wynik.append((y+1)+" ");
            for (int x = 0; x < 8; x++) {
                if (this.pola[x][y].empty()) {
                    if (x % 2 == y % 2)
                        wynik.append(blackBox);
                    else
                        wynik.append(whiteBox);
                }
                else {
                    wynik.append(this.pola[x][y].piece().toString());
                }
            }
            wynik.append("\n");
        }
        wynik.append("\n  ABCDEFGH\n");
        return wynik.toString();
    }

    public Tile tile(int x, int y){
        return this.pola[x][y];
    }

    public void przenies(Tile p, Tile q) {
        if (!q.empty()) {
            //System.out.println(p.piece().toString() +" bije "+q.piece().toString());
            if (q.piece().isKing())
                this.martwyKrol = q.piece().kolor();
        }
        this.pola[q.x()][q.y()].setPuste(false);
        this.pola[q.x()][q.y()].setBierek(p.piece());
        this.pola[p.x()][p.y()].setPuste(true);

        int x = 1;
    }

    public Color MartwyKrol() {
        return this.martwyKrol;
    }

    @Override
    public Board clone() {
        return new Board(this.pola);
    }

    public Integer iloscBierek(Color color) {
        Integer licznik = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (!this.pola[x][y].empty() && this.pola[x][y].piece().kolor() == color)
                    licznik++;
            }
        }
        return licznik;
    }
}

