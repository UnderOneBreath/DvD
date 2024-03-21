import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    private int x = 10;
    private int y = 10;
    private int d = 30;
    private int xchange = 1;
    private int ychange = 1;
    private Image dbImage;
    private Graphics dbg;
    public static int widthScreen = 800;
    public static int heightScreen = 400;

    public static void main(String[] args) {
        window frame = new window();
        frame.setBounds(10,10,widthScreen, heightScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true) {
            frame.ball_bounce();
            frame.repaint();
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void ball_bounce(){
        if(x + xchange < 0 || x + d + xchange > getWidth()){
            xchange *= -1;
        }
        if(y + ychange < 0 || y + d + ychange > getHeight()){
            ychange *= -1;
        }
        x += xchange;
        y += ychange;
    }
    public void paint(Graphics g){
        dbImage = createImage(widthScreen, heightScreen);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        g.fillOval(x,y,d,d);
        repaint();
    }
}