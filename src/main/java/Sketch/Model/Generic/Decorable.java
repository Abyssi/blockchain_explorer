package Sketch.Model.Generic;

public abstract class Decorable<T> {
    private T base;

    public Decorable(T base) {
        this.base = base;
    }

    public T getBase() {
        return this.base;
    }

}
