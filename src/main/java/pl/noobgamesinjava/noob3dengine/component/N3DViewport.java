package pl.noobgamesinjava.noob3dengine.component;

import java.awt.*;
import java.awt.image.ImageObserver;

public class N3DViewport extends Canvas {

    private Image frame;
    private ImageObserver observer;

    public N3DViewport(int width, int height, int posX, int posY) {

        setBackground(Color.black);
        setSize(width, height);
        setLocation(posX, posY);
    }

    public void paint(Graphics g) {
        renderFrame(g);
    }

    private void renderFrame(Graphics g) {
        g.drawImage(frame, 0, 0, observer);
    }

    public void setFrame(Image frame) {
        this.frame = frame;
    }

    public void setImageObserver(ImageObserver observer) {
        this.observer = observer;
    }

}
