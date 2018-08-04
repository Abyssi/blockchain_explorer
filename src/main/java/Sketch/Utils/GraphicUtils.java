package Sketch.Utils;

import processing.core.PGraphics;


public class GraphicUtils {
    public static void DrawArrow(PGraphics graphics, float x1, float y1, float x2, float y2, float radius) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float angle = (float) Math.atan2(dy, dx);
        float len = (float) Math.sqrt(dx * dx + dy * dy) - (radius * 2);

        graphics.pushMatrix();
        graphics.translate(x1, y1);
        graphics.rotate(angle);
        graphics.translate(radius, 0);
        graphics.line(0, 0, len, 0);
        graphics.line(len, 0, len - 8, -8);
        graphics.line(len, 0, len - 8, 8);
        graphics.popMatrix();
    }
}
