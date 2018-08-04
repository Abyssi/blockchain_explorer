package Sketch.Core.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph<T extends Node> {
    private List<T> nodes;
    private List<Edge<T>> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graph(List<T> nodes, List<Edge<T>> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<T> getNodes() {
        return nodes;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void add(String id, NodeSupplier<T, ConnectedNode<T>> supplier) {
        this.add(id, null, supplier);
    }

    public void add(ConnectedNode<T> connectedNode, NodeSupplier<T, ConnectedNode<T>> supplier) {
        if (connectedNode == null) return;

        this.nodes.add(connectedNode.getBase());

        for (String s : connectedNode.getOut())
            this.add(s, connectedNode.getBase(), supplier);
    }

    public void add(String id, T source, NodeSupplier<T, ConnectedNode<T>> supplier) {
        Optional<T> dest = find(id);
        if (dest.isPresent()) {
            if (source != null)
                this.edges.add(new Edge<>(source, dest.get()));
        } else {
            ConnectedNode<T> connectedDest = supplier.supply(source, id);
            if (connectedDest != null) {
                this.add(connectedDest, supplier);
                if (source != null)
                    this.edges.add(new Edge<>(source, connectedDest.getBase()));
            }
        }

    }

    public Optional<T> find(String id) {
        for (T node : this.nodes)
            if (node.getId().equals(id))
                return Optional.of(node);
        return Optional.empty();
    }
}
