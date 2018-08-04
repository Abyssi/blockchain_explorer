package Sketch.Core.Vectors;

public class Vector2D extends Vector {

    public Vector2D() {
        super(2);
    }

    public Double getX() {
        return this.get(0);
    }

    public void setX(Double x) {
        this.set(0, x);
    }

    public Double getY() {
        return this.get(1);
    }

    public void setY(Double y) {
        this.set(1, y);
    }

    public void set(Double x) {
        this.setX(x);
    }

    public void set(Double x, Double y) {
        this.set(x);
        this.setY(y);
    }

}
