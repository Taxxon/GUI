import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    public AWT () {
        Dimension dim = new Dimension(width, height);
        setPreferredSize(dim);
        frame = new JFrame("MYLIFEISAWSOME");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void LoadImageApp(){
        try {
            img = ImageIO.read(new File("Namnlös.img"));
        } catch (IOException e) {
        }
    }

    //ritar en gubbe
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawOval(100, 100, 50, 50);
        g.drawRect(120, 150 ,10,15);
        g.drawOval(100, 165, 50, 100);
        g.drawRect(50, 200, 50,15);
        g.drawRect(50, 160, 15, 40);
        g.drawRect(150, 200, 50,15);
        g.drawRect(185, 160, 15, 40);
        g.drawLine(130, 265, 160 , 340);
        g.drawLine(140, 255, 175 , 340);
        g.drawLine(110, 255, 75, 340);
        g.drawLine(120, 265, 90, 340);
        g.drawOval(50,340,50,20);
        g.drawOval(150, 340,50,20);

        g.drawImage( img, 0, 0, null);
    }

    public static void main(String[] args) {
        AWT mittPRG = new AWT();
    }
}



