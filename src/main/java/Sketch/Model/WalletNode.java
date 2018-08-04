package Sketch.Model;

import Sketch.Core.Graph.OrientedNode;

public class WalletNode extends OrientedNode {
    private Double totalReceived;

    public WalletNode(String id, int index, Double totalReceived) {
        super(id, index);
        this.totalReceived = totalReceived;
    }

    public Double getTotalReceived() {
        return totalReceived;
    }
}
