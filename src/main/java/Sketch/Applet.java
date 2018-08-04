package Sketch;

import Sketch.Core.BlockchainInfoWalletNodeSupplier;
import Sketch.Core.GraphicableWalletGraph;
import processing.core.PApplet;

public class Applet extends PApplet {

    private Cam cam;
    private GraphicableWalletGraph graphicableWalletGraph;

    public void settings() {
        size(1920, 1080);
        pixelDensity(displayDensity());

        cam = new Cam(this);

        String[] addresses = {"13AM4VW2dhxYgXeQepoHkHSQuy6NgaEb94", "12t9YDPgwueZ9NyMgw519p7AA8isjr6SMw", "115p7UMMngoj1pMvkpHijcRdfJNXj6LrLn"};

        this.graphicableWalletGraph = new GraphicableWalletGraph();
        for (String address : addresses)
            this.graphicableWalletGraph.getBase().add(address, new BlockchainInfoWalletNodeSupplier(3));
        this.graphicableWalletGraph.rebalance();

        //Neo4J.sharedInstance().write(this.graphicableWalletGraph.getBase(), addresses);
    }

    public void draw() {
        cam.apply();

        background(255);

        this.graphicableWalletGraph.update();
        this.graphicableWalletGraph.draw(this.g);
    }
}
