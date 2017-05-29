import java.awt.*;
/**
 * Created by emka15 on 2017-05-29.
 */
public class DoubleBuffer extends Panel {

   private int bufferWidth = 600;
   private int bufferHeight = 400;
   private Image bufferImage;
   private Graphics bufferGraphics;

    public DoubleBuffer(){
        super();

    }

    public void uppdate(Graphics g){
        paint(g);

    }

    public void paint(Graphics g){
        if(bufferWidth != getSize().width ||
           bufferHeight != getSize().height ||
           bufferImage == null || bufferGraphics == null);

        resetBuffer();

        if (bufferGraphics != null){
            bufferGraphics.clearRect(0,0, bufferWidth, bufferHeight);
            paint(bufferGraphics);
            g.drawImage(bufferImage, 0, 0, this);
        }
    }

    public void paintBuffer(Graphics g){

    }

    private  void resetBuffer(){
        bufferWidth=getSize().width;
        bufferHeight=getSize().height;

        if(bufferGraphics != null){
            bufferGraphics.dispose();
            bufferGraphics = null;
        }

        if(bufferImage != null){
            bufferImage.flush();
            bufferImage = null;
        }
        System.gc();

        bufferImage = createImage(bufferWidth,bufferHeight);
        bufferGraphics = bufferImage.getGraphics();
    }
}
