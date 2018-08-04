package Sketch.Core.Graph;

public abstract class NodeSupplier<N extends Node, T extends ConnectedNode<N>> {
    public abstract T supply(N source, String id);
}
