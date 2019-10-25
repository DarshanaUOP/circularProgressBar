import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *  created by darshana Ariyarathna
 * IMPORTANT :
 *      radius, BarColor,fontColor are required from initialization
 */

public class CustomPannel extends JPanel {

    //Default Values:
    int Progress=0;
    int radius=100;
    Color barColor=Color.black;
    Color fontColor=Color.black;

    public  void Update(int num){
        Progress = num;
    }

    @Override
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D g2=(Graphics2D)g;

        g2.translate(this.getWidth()/2,this.getHeight()/2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.rotate(Math.toRadians(270));

        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrameFromCenter(new Point(0,0),new Point(radius,radius));

        Ellipse2D circle=new Ellipse2D.Float(0,0,100,100);
        circle.setFrameFromCenter(new Point(0,0),new Point(radius*11/12, radius*11/12));        //RADIUS OF INNER CIRCLE IS 11/12 OF RADIUS.

        arc.setAngleStart(0);
        arc.setAngleExtent(-Progress*3.6);
        g2.setColor(barColor);

        g2.draw(arc);
        g2.fill(arc);
        g2.setColor(Color.white);
        g2.draw(circle);
        g2.fill(circle);

        g2.setColor(fontColor);
        g2.rotate(Math.toRadians(90));
        g.setFont(new Font(null,Font.PLAIN,radius/2));
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(Progress + "%",g);
        int x= (0 - (int)r.getWidth())/2;
        int y= (0 - (int)r.getWidth())/2 +fm.getAscent();

        g2.drawString(Progress + "%",x,y);
    }
}
