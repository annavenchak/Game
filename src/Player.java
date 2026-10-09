import java.awt.*;

public class Player {
    private  double x;
    private double y;
    private int r;
    private Color color1;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean isFiring;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private int speed;
    public Player(){
        x = GamePanel.width/2;
        y = GamePanel.height/2;
        r = 5;
        color1 = Color.MAGENTA;
        speed = 5;
        up = false;
        down = false;
        left = false;
        right = false;
        isFiring = false;
    }
    public  void  update(){
    if (up && y>r){
        y-=speed;
    }
        if (down && y<GamePanel.height-r){
            y+=speed;
        }
        if (left && x>r){
            x-=speed;
        }
        if (right && x<GamePanel.width-r){
            x+=speed;
        }
        if (isFiring){
            GamePanel.bullets.add(new Bullet());
        }
    }
    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval((int)(x-r),(int)(y-r),2*r, 2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color1.darker());
        g.fillOval((int)(x-r),(int)(y-r),2*r,2*r);
        g.setStroke(new BasicStroke(1));
    }

}
