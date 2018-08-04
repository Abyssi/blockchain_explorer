package Sketch.Core.Vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix extends ArrayList<Vector> {
    public Matrix() {
        super();
    }

    public Matrix(int rows, int columns) {
        super(IntStream.range(0, rows).mapToObj(i -> new Vector(columns)).collect(Collectors.toList()));
    }

    public Matrix(Double[][] values) {
        super(Arrays.stream(values).map(Vector::new).collect(Collectors.toList()));
    }

    public Matrix(List<List<Double>> values) {
        super(values.stream().map(Vector::new).collect(Collectors.toList()));
    }

    //TODO: implements matrix operation, this class is only a placeholder that needs to be filled
}
