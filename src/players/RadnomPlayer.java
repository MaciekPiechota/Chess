package players;

import pieces.Color;
import pieces.Tile;

import java.util.ArrayList;
import java.util.Random;

public class RadnomPlayer extends Player {
    public RadnomPlayer(Color colorGracza) {
        super(colorGracza);
    }

    public boolean makeMove() {
        if (Player.board.MartwyKrol() != null && Player.board.MartwyKrol() == this.playerColor)
            return false;

        ArrayList<Tile> polaGracz = Player.board.bierki(this.playerColor);
        ArrayList<Tile> polaBezRuchow = new ArrayList<>();
        for (Tile p : polaGracz) {
            if (p.piece().possibleMoves(Player.board,p.x(),p.y()).size() == 0)
                polaBezRuchow.add(p);
        }
        polaGracz.removeAll(polaBezRuchow);
        
        if (polaGracz.size() == 0)
            return false;

        // ruch odbywa sie bierkiem z pola a
        Random random = new Random();
        int losowyBierek = random.nextInt(polaGracz.size());
        Tile a = polaGracz.get(losowyBierek);
        ArrayList<Tile> mozliweRuchyA = a.piece().possibleMoves(Player.board,a.x(),a.y());

        int losowyRuch = random.nextInt(mozliweRuchyA.size());
        Player.board.przenies(a,mozliweRuchyA.get(losowyRuch));
        return true;
    }
}
