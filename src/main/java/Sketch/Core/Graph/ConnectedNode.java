package Sketch.Core.Graph;

import Sketch.Model.Generic.Decorable;

import java.util.ArrayList;
import java.util.List;

public class ConnectedNode<T extends Node> extends Decorable<T> {
    private List<String> out;

    public ConnectedNode(T base) {
        this(base, new ArrayList<>());
    }

    public ConnectedNode(T base, List<String> out) {
        super(base);
        this.out = out;
    }

    public List<String> getOut() {
        return out;
    }
}
