package players.minmax;

import chess.Board;
import pieces.Tile;

import java.util.ArrayList;

public class Node {
    protected Node father;
    protected ArrayList<Node> children = new ArrayList<>();
    protected int value;
    protected Tile moveOrigin;
    protected Tile moveDestination;
    protected Board board;

    public Node(Node father,int value,Tile moveOrigin, Tile moveDestination,Board board) {
        this.father = father;
        this.value = value;
        this.moveDestination = moveDestination;
        this.moveOrigin = moveOrigin;
        this.board = board;
    }

}
