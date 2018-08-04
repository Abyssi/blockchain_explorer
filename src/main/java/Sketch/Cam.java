package Sketch;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class Cam {
    private PApplet applet;
    private InputEventListener inputEventListener;

    public Cam(PApplet applet) {
        this.applet = applet;
        this.inputEventListener = new InputEventListener();

        this.applet.registerMethod("mouseEvent", this.inputEventListener);
        this.applet.registerMethod("keyEvent", this.inputEventListener);
    }

    public void apply() {
        applet.resetMatrix();
        if (applet.sketchRenderer().equals("processing.awt.PGraphicsJava2D")) {
            applet.translate(inputEventListener.xShift, inputEventListener.yShift);
            applet.scale(PApplet.map(inputEventListener.zShift, -300, 300, 2, 10e-5f));
        } else
            applet.translate(inputEventListener.xShift, inputEventListener.yShift, inputEventListener.zShift);
    }

    protected class InputEventListener {
        private float xOffset, yOffset, xShift, yShift, zShift;

        public void keyEvent(final KeyEvent e) {
            //TODO: needs to be implemented
        }

        public void mouseEvent(final MouseEvent e) {
            switch (e.getAction()) {
                case MouseEvent.PRESS:
                    xOffset = e.getX() - xShift;
                    yOffset = e.getY() - yShift;
                    break;

                case MouseEvent.DRAG:
                    xShift = e.getX() - xOffset;
                    yShift = e.getY() - yOffset;
                    break;

                case MouseEvent.WHEEL:
                    zShift += e.getCount() * 10;
                    break;
            }
        }
    }
}
