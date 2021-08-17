package players.minmax;

import java.util.Comparator;

public class CompNode implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return a.value <= b.value ? -1 : 1;
    }
}
