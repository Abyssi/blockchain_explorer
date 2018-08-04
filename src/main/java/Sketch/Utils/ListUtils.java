package Sketch.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListUtils {

    public static <T> List<T> RemovingDuplicates(List<T> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
}
