package Sketch.Core;

import Sketch.Core.Graph.Edge;
import Sketch.Core.Graph.OrientedGraph;
import Sketch.Model.Generic.Graphicable;
import Sketch.Model.Interfaces.Drawer;
import Sketch.Utils.GraphicUtils;
import Sketch.Utils.RandomUtils;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class GraphicableWalletGraph extends Graphicable<OrientedGraph<GraphicableWalletNode>> {

    private Drawer<Edge<GraphicableWalletNode>> edgeDrawer = (edge, graphics) -> {
        graphics.stroke(28, 28, 28, 255 * 0.8f);
        graphics.strokeWeight(1.1f);

        GraphicUtils.DrawArrow(graphics,
                edge.getA().getState().getPosition().getX().floatValue(),
                edge.getA().getState().getPosition().getY().floatValue(),
                edge.getB().getState().getPosition().getX().floatValue(),
                edge.getB().getState().getPosition().getY().floatValue(),
                25
        );
    };

    public GraphicableWalletGraph() {
        super(new OrientedGraph<>());
    }

    @Override
    public void draw(PGraphics graphics) {
        for (GraphicableWalletNode graphicableWalletNode : this.getBase().getNodes())
            graphicableWalletNode.draw(graphics);

        for (Edge<GraphicableWalletNode> graphicableWalletNodeEdge : this.getBase().getEdges())
            edgeDrawer.draw(graphicableWalletNodeEdge, graphics);
    }

    @Override
    public void update() {
        super.update();
        for (GraphicableWalletNode graphicableWalletNode : this.getBase().getNodes())
            graphicableWalletNode.update();
    }

    public void rebalance() {
        // This is an easy visualization using deepness index
        // We could use Fruchterman and Reingold's graph layout algorithm using force-directed placement
        float xStep = 200;
        float yStep = 100;
        float xRandomSlide = 20;
        float yRandomSlide = 15;
        List<Integer> layerNodeCounts = new ArrayList<>();
        for (GraphicableWalletNode graphicableWalletNode : this.getBase().getNodes()) {
            for (int i = layerNodeCounts.size(); i <= graphicableWalletNode.getIndex(); i++)
                layerNodeCounts.add(1);
            layerNodeCounts.set(graphicableWalletNode.getIndex(), layerNodeCounts.get(graphicableWalletNode.getIndex()) + 1);
            graphicableWalletNode.getState().getPosition().set(
                    graphicableWalletNode.getIndex() * xStep + RandomUtils.RandomDouble(-xRandomSlide, xRandomSlide),
                    layerNodeCounts.get(graphicableWalletNode.getIndex()) * yStep + RandomUtils.RandomDouble(-yRandomSlide, yRandomSlide));
        }
    }
}
