package Sketch.Core.Graph;

public class NullNodeSupplier<N extends Node> extends NodeSupplier<N, ConnectedNode<N>> {
    @Override
    public ConnectedNode<N> supply(N source, String id) {
        return null;
    }
}
