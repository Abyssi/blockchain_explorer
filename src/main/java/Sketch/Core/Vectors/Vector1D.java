package Sketch.Core.Vectors;

public class Vector1D extends Vector {

    public Vector1D() {
        super(1);
    }

    public Double getX() {
        return this.get(0);
    }

    public void setX(Double x) {
        this.set(0, x);
    }

    public void set(Double x) {
        this.setX(x);
    }

}
