import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by emka15 on 2017-05-08.
 */
public class AWT extends Canvas {

    JFrame frame;
    int width = 600;
    int height = 400;
    BufferedImage img;
    Timer timer = null;
    int offset = 0;

    public AWT () {
        LoadImageApp();
        Dimension dim = new Dimension(width, height);
        setPreferredSize(dim);
        frame = new JFrame("MYLIFEISAWSOME");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(new KeyListener());
    }

    public void LoadImageApp(){
        //hämtar bilden
        try {
            img = ImageIO.read(new File("Namnlos.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Dimension getPreferredSize() {
        //bestämer storleken på fönstret
        if (img == null) {
            return new Dimension( width, height);
        } else {
            return new Dimension( img.getWidth(null)+ width,  img.getHeight(null));
        }
    }

    public void paint(Graphics g) {
        //ritar en gubbe
        g.setColor(Color.GREEN);
        g.drawOval(100+offset, 100, 50, 50);
        g.drawRect(120+offset, 150 ,10,15);
        g.drawOval(100+offset, 165, 50, 100);
        g.drawRect(50+offset, 200, 50,15);
        g.drawRect(50+offset, 160, 15, 40);
        g.drawRect(150+offset, 200, 50,15);
        g.drawRect(185+offset, 160, 15, 40);
        g.drawLine(130+offset, 265, 160+offset, 340);
        g.drawLine(140+offset, 255, 175+offset, 340);
        g.drawLine(110+offset, 255, 75+offset, 340);
        g.drawLine(120+offset, 265, 90+offset, 340);
        g.drawOval(50+offset,340,50,20);
        g.drawOval(150+offset , 340,50,20);

        //ritar ut en bild med ett hus och ett träd
        g.drawImage( img, 600, 0, null);
    }

    public class KeyListener extends KeyAdapter{

        public void keyPressed(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e){
            switch (e.getKeyCode()) {

                case KeyEvent.VK_SPACE:

                    offset++;
                    repaint();

                    break;

            }
        }

    }







    public static void main(String[] args) {
        AWT mittPRG = new AWT();
    }
}



