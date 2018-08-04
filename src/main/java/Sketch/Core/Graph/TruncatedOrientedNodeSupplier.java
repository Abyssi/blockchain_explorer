package Sketch.Core.Graph;

public abstract class TruncatedOrientedNodeSupplier<T extends OrientedNode> extends NodeSupplier<T, ConnectedNode<T>> {
    private int maxDeepness;

    public TruncatedOrientedNodeSupplier(int maxDeepness) {
        this.maxDeepness = maxDeepness;
    }

    @Override
    public ConnectedNode<T> supply(T source, String id) {
        return (source == null ? 0 : source.getIndex()) <= maxDeepness ? truncatedSupply(source, id) : null;
    }

    public abstract ConnectedNode<T> truncatedSupply(T source, String id);
}
