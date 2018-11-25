package pl.noobgamesinjava.noob3dengine.component;

import pl.noobgamesinjava.noob3dengine.render.FramesRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;

public class DefaultGameWindow extends Frame {

    static GraphicsConfiguration gc;
    FramesRenderer framesRenderer;

    public DefaultGameWindow(int width, int height, int posX, int posY) {
        super(gc);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                framesRenderer.end();
                dispose();
            }
        });

        setLayout(null);
        setLocation(posX, posY);
        setSize(width, height);

        setVisible(true);
        Insets insets = getInsets();

        N3DViewport viewport = new N3DViewport(width, height, insets.left, insets.top);
        viewport.setLocation(insets.left, insets.top);
        add(viewport);

        framesRenderer = new FramesRenderer(viewport);
        framesRenderer.start();

//        new Thread() {
//            public void run() {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                viewport.setFrame(Color.BLUE);
//                viewport.repaint();
//            }
//        }.start();


        setSize(width + insets.right + insets.left, height + insets.top + insets.bottom);
    }

}
