import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Created by emka15 on 2017-05-08.
 */
public class AWT extends Canvas {

    String tim = "Här står tiden när du når till huset";
    long startTime = 0;
    long endTime = 0;
    JFrame frame;
    int width = 600;
    int height = 400;
    Image img;
    Graphics bdg;
    Graphics g;
    int offset = 0;
    long start = System.nanoTime();


    public AWT () {
        // så att man ser det man ser
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
        //hämtar bilden där huset och trädet är
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

    public void paint(Graphics bdg) {
        // gör så att det flickrar mindre
        if (img == null) {
            img = createImage(img.getWidth(null) + width, img.getHeight(null));
            if (img == null) {
                System.out.println("Img is still null");
                return;
            } else {
                bdg = img.getGraphics();
            }
        }
        bdg.setColor(Color.WHITE);
        bdg.fillRect(0, 0, width, height);
        draw(bdg);
    }

    public  void draw(Graphics g) {

        //ritar ut en bild med ett hus och ett träd
        g.drawImage( img, 600, 0, null);

        //ritar en gubbe
        g.setColor(Color.RED);
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
        g.drawString(tim, 400, 100);
        g.drawString("Använd tangenterna S och D för att röra på dig framåt", 370, 120);
        // här är timern
        if(offset == 5) {
            startTime = System.nanoTime();
        } else if (offset == 640) {
            endTime = System.nanoTime();
            long time = endTime - startTime;
            time = time / 1000000000;
            tim = toString(time) + "sekunder";
        }
    }



    public class KeyListener extends KeyAdapter {
        // gör så att killen rör sog mot huset när man släpper tangenterna
        public void keyPressed(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e){

            switch (e.getKeyCode()) {

                case KeyEvent.VK_D:
                    offset = offset + 5;
                    repaint();

                    break;
                case KeyEvent.VK_S:
                    offset = offset + 5;
                    repaint();
            }
        }

    }

    public String toString (float x){
        // skriver om tiden till en String
        String string = x + "";
        return string;
    }


    public static void main(String[] args) {
        //gör så att det kommer up
        AWT prgTest = new AWT();
    }

}




