package Sketch.Utils;

import java.util.function.Supplier;

public class FileCache {
    private static final String EXTENSION = ".cached";

    private String path;

    public FileCache(String path) {
        this.path = path;
    }

    public String get(String id) {
        String finalPath = path + HashUtils.MD5(id) + EXTENSION;
        return FileUtils.Exists(finalPath) ? FileUtils.Read(finalPath) : null;
    }

    public String put(String id, String content) {
        String finalPath = path + HashUtils.MD5(id) + EXTENSION;
        FileUtils.Write(finalPath, content);
        return content;
    }

    public boolean has(String id) {
        return FileUtils.Exists(path + HashUtils.MD5(id) + EXTENSION);
    }

    public String getOrPut(String id, Supplier<String> other) {
        return has(id) ? get(id) : put(id, other.get());
    }
}
