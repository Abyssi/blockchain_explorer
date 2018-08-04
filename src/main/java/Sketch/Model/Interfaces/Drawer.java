package Sketch.Model.Interfaces;

import processing.core.PGraphics;

public interface Drawer<T> {
    void draw(T t, PGraphics graphics);
}
