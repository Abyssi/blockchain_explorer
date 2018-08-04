package Sketch.Core;

import Sketch.Model.Generic.State;
import Sketch.Model.Interfaces.Drawable;
import Sketch.Model.Interfaces.Stated;
import Sketch.Model.Interfaces.Updatable;
import Sketch.Model.WalletNode;
import processing.core.PGraphics;

import java.text.DecimalFormat;

public class GraphicableWalletNode extends WalletNode implements Drawable, Updatable, Stated {
    private State state;

    public GraphicableWalletNode(String id, int index, Double totalReceived) {
        super(id, index, totalReceived);
        this.state = new State();
    }

    @Override
    public void draw(PGraphics graphics) {
        graphics.fill(64, 64, 64);
        graphics.stroke(28, 28, 28);
        graphics.strokeWeight(1);
        graphics.ellipseMode(graphics.CENTER);
        graphics.ellipse(this.state.getPosition().getX().floatValue(), this.state.getPosition().getY().floatValue(), 50f, 50f);

        graphics.fill(250, 250, 250);
        graphics.textSize(10);
        graphics.textAlign(graphics.CENTER);
        graphics.text(new DecimalFormat("#.###").format(this.getTotalReceived()), this.getState().getPosition().getX().floatValue(), this.getState().getPosition().getY().floatValue() + 5);

        graphics.fill(64, 64, 64);
        graphics.textSize(8);
        graphics.text(this.getId(), this.getState().getPosition().getX().floatValue(), this.getState().getPosition().getY().floatValue() + 25 + 6 + 4);
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void update() {
        this.state.update();
    }
}
