package Sketch.Model.Generic;

import Sketch.Model.Interfaces.Drawable;
import Sketch.Model.Interfaces.Stated;
import Sketch.Model.Interfaces.Updatable;

public abstract class Graphicable<T> extends Decorable<T> implements Drawable, Updatable, Stated {
    private State state;

    public Graphicable(T base) {
        super(base);
        this.state = new State();
    }

    public void update() {
        this.state.update();
    }

    public State getState() {
        return this.state;
    }
}
