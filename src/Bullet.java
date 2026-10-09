import java.awt.*;

public class Bullet {
    private Color color;
    private double x;
    private double y;
    private int r;
    private int speed;

    public double getX() {
        return x;
    }

    public int getR() {
        return r;
    }

    public Bullet(){
    x = GamePanel.player.getX();
    y = GamePanel.player.getY();
    r = 2;
    color = Color.WHITE;
    speed = 10;
    }

public  void  update(){
    y-=speed;
}

public void  draw(Graphics2D g){
    g.setColor(color);
    g.fillOval((int)x, (int)y, r, r*2);
}

    public double getY() {
        return y;
    }
}
