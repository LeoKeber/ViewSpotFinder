import java.util.ArrayList;
import java.util.List;

public class Node {

    private final List<Integer> elementIndices;

    public Node() {
        elementIndices = new ArrayList<>();
    }

    public void addIndex(int index){
        elementIndices.add(index);
    }
    public List<Integer> getElementIndices() {
        return elementIndices;
    }
}
