package players;

import pieces.Color;
import pieces.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AgressivePlayer extends Player {
    public AgressivePlayer(Color colorGracza) {
        super(colorGracza);
    }

    @Override
    public boolean makeMove() {
        if (Player.board.MartwyKrol() != null && Player.board.MartwyKrol() == this.playerColor)
            return false;

        // pobranie od szachownicy pol z bierkami danego koloru
        ArrayList<Tile> polaGracza = Player.board.bierki(this.playerColor);
        // usywamy pola z bierkami bez ruchow
        ArrayList<Tile> polaBezRuchow = new ArrayList<>();
        for (Tile p : polaGracza) {
            if (p.piece().possibleMoves(Player.board,p.x(),p.y()).size() == 0)
                polaBezRuchow.add(p);
        }
        polaGracza.removeAll(polaBezRuchow);

        if (polaGracza.size() == 0)
            return false;

        //tworzymy hashmape w ktorej klucz to pole z bierkiem a wartosc do ruchy bierka ktora gwarantuja bicie
        HashMap<Tile,ArrayList<Tile>> ruchy = new HashMap<>();
        for (Tile a : polaGracza) {
            ArrayList<Tile> ruchyA = new ArrayList<>();
            for (Tile b : a.piece().possibleMoves(Player.board,a.x(),a.y())) {
                if (!b.empty()) {
                    if (b.piece().isKing()) {
                        Player.board.przenies(a,b);
                        return true;
                    }
                    else
                        ruchyA.add(b);
                }
            }
            if (ruchyA.size() > 0)
                ruchy.put(a,ruchyA);
        }

        if (ruchy.size() == 0) {
            // nie ma przesuniecia gwarantujacego bicie
            Random random = new Random();
            int losowyBierek = random.nextInt(polaGracza.size());
            Tile a = polaGracza.get(losowyBierek);
            ArrayList<Tile> mozliweRuchyA = a.piece().possibleMoves(Player.board,a.x(),a.y());
            int losowyRuch = random.nextInt(mozliweRuchyA.size());
            Player.board.przenies(a,mozliweRuchyA.get(losowyRuch));
        }
        else {
            // wybranie przesuniecia gwarantujacego bicie
            Random random = new Random();
            int ruch = random.nextInt(ruchy.size());
            Tile[] keys = ruchy.keySet().toArray(new Tile[0]);
            Tile p = keys[ruch];
            ArrayList<Tile> ruchyP = ruchy.get(p);
            int losowyRuch = random.nextInt(ruchyP.size());
            Player.board.przenies(p, ruchyP.get(losowyRuch));
        }
        return true;
    }

}
