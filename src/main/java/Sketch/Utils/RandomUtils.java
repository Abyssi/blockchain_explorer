package Sketch.Utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    public static double RandomDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

}
