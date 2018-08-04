package Sketch.Core.Vectors;

import java.util.*;

public class Vector extends ArrayList<Double> {

    private static final double EPSILON = 10e-6;

    public Vector() {
        super();
    }

    public Vector(int n) {
        super(Collections.nCopies(n, 0d));
    }

    public Vector(Double[] values) {
        super(Arrays.asList(values));
    }

    public Vector(List<Double> values) {
        super(values);
    }

    public Double euclideanLength() {
        return length(2);
    }

    public Double length(int pow) {
        return Math.pow(this.poweredLength(pow), 1d / pow);
    }

    public Double poweredLength(int pow) {
        Double result = 0d;
        for (Double value : this)
            result += Math.pow(value, pow);
        return result;
    }

    public Double euclideanDistance(Vector vector) {
        return distance(vector, 2);
    }

    public Double distance(Vector vector, int pow) {
        return Math.pow(this.poweredDistance(vector, pow), 1d / pow);
    }

    public Double poweredDistance(Vector vector, int pow) {
        if (this.size() != vector.size())
            return 0d;

        Double result = 0d;
        for (ListIterator<Double> i = this.listIterator(), j = vector.listIterator(); i.hasNext(); )
            result += Math.pow(i.next() - j.next(), pow);
        return result;
    }

    public void dot(Double k) {
        for (ListIterator<Double> i = this.listIterator(); i.hasNext(); )
            i.set(i.next() * k);
    }

    public void divide(Double k) {
        this.dot(1 / k);
    }

    public void dot(Vector vector) {
        for (ListIterator<Double> i = this.listIterator(), j = vector.listIterator(); i.hasNext(); )
            i.set(i.next() * j.next());
    }

    public void addToAll(Double k) {
        for (ListIterator<Double> i = this.listIterator(); i.hasNext(); )
            i.set(i.next() + k);
    }

    public void subtractToAll(Double k) {
        this.add(-k);
    }

    public void add(Vector vector) {
        for (ListIterator<Double> i = this.listIterator(), j = vector.listIterator(); i.hasNext(); )
            i.set(i.next() + j.next());
    }

    public void set(Double[] values) {
        this.clear();
        this.addAll(Arrays.asList(values));
    }

    public boolean equals(Vector vector) {
        return euclideanDistance(vector) < EPSILON;
    }

}
