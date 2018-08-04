package Sketch.Core.Graph;

public class Edge<T extends Node> {
    private T a;
    private T b;

    public Edge(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }
}
