package Sketch.Core.Vectors;

public class Vector3D extends Vector {

    public Vector3D() {
        super(3);
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

    public Double getZ() {
        return this.get(2);
    }

    public void setZ(Double z) {
        this.set(2, z);
    }

    public void set(Double x) {
        this.setX(x);
    }

    public void set(Double x, Double y) {
        this.set(x);
        this.setY(y);
    }

    public void set(Double x, Double y, Double z) {
        this.set(x, y);
        this.setZ(z);
    }

}
