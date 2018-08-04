package Sketch.Core.Graph;

public class OrientedNode extends Node {
    private int index;

    public OrientedNode(String id, int index) {
        super(id);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
