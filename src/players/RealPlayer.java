package players;

import pieces.Color;

public class RealPlayer extends Player {
    public RealPlayer(Color colorGracza) {
        super(colorGracza);
    }

    @Override
    public boolean makeMove() {
        return false;
    }
}
