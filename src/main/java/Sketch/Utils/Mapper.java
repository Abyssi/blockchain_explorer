package Sketch.Utils;

import java.util.function.Function;

public class Mapper {
    public static <R, T> R map(T t, Function<T, ? extends R> mapper) {
        return mapper.apply(t);
    }
}
