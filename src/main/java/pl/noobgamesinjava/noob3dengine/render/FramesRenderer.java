package pl.noobgamesinjava.noob3dengine.render;

import pl.noobgamesinjava.noob3dengine.component.N3DViewport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FramesRenderer extends Thread {

    private boolean end = false;
    private N3DViewport viewport;
    private Graphics2D frame;
    private int counter = 0;

    public FramesRenderer(N3DViewport viewport) {
        super();
        this.viewport = viewport;


        viewport.setImageObserver((img, infoflags, x, y, w, h) -> {
            return true;
        });
    }

    @Override
    public void run() {
        while (!end) {
            Image image = new BufferedImage(viewport.getWidth(), viewport.getHeight(), BufferedImage.TYPE_INT_RGB);
            frame = ((BufferedImage) image).createGraphics();

            frame.setBackground(Color.BLACK);
            frame.drawLine(10, 10, 300, counter);

            viewport.setFrame(image);
            viewport.repaint();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

    public void end() {
        end = true;
    }
}
