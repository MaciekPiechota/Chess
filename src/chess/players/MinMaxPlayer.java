package players;

import chess.Board;
import pieces.Color;

public class MinMaxPlayer extends Player{

    public MinMaxPlayer(Color colorGracza) {
        super(colorGracza);
    }

    @Override
    public boolean makeMove() {
        return false;
    }

    public int evaluateFuntion(Board board) {

        return 0;
    }
}
