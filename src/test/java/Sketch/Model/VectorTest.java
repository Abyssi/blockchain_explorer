package Sketch.Model;

import Sketch.Core.Vectors.Vector;
import org.junit.jupiter.api.Test;

class VectorTest {
    @Test
    void euclideanLength() {
        System.out.println(new Vector(new Double[]{10d, 10d, 10d}).euclideanLength());
    }

    @Test
    void euclideanDistance() {
        System.out.println(new Vector(new Double[]{10d, 10d, 10d}).euclideanDistance(new Vector(new Double[]{10d, 10d, 1d})));
    }

    @Test
    void dot() {
        Vector vector = new Vector(new Double[]{10d, 10d, 10d});
        vector.dot(10d);
        System.out.println(vector);
    }
}