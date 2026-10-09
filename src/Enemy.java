import java.awt.*;

public class Enemy {
    private double x;
    private double y;
    private  double dx;
    private  double dy;
    private double health;
    private int r;
    private Color color;
    private int speed;
    private int rang;
    private int type;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public Enemy(int type, int rang) {
        this.rang = rang;
        this.type = type;
        switch (type){
            case 1:
                health = 5;
                break;
            case 2:
                health = 3;
                break;
            case 3:
                health = 7;
                break;
            case 4:
                health = 10;
                break;
        }
        switch (rang) {
            case 1:
                color = Color.GREEN;
                x = Math.random()*GamePanel.width;
                y = 0;
                r = 7;
                speed = 2;
                double angle = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle)*speed;
                dy = Math.cos(angle)*speed;
                break;
            case 2:
                color = Color.RED;
                x = Math.random()*GamePanel.width;
                y = 0;
                r = 3;
                speed = 7;
                double angle2 = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle2)*speed;
                dy = Math.cos(angle2)*speed;
                break;
            case 3:
                color = Color.WHITE;
                x = Math.random()*GamePanel.width;
                y = 0;
                r = 3;
                speed = 7;
                double angle3 = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle3)*speed;
                dy = Math.cos(angle3)*speed;
                break;
            case 4:
                color = Color.ORANGE;
                x = Math.random()*GamePanel.width;
                y = 0;
                r = 7;
                speed = 5;
                double angle4 = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle4)*speed;
                dy = Math.cos(angle4)*speed;
                break;
        }
    }
    public void hit(){
        health--;
    }

    public boolean remove(){
        if (health<=0){
            return  true;
        }
        return  false;
    }
    public void update(){
        x+=dx;
        y+=dy;
        if (x<0 && dx<0){
            dx = Math.abs(dx);
        }
        if (x>GamePanel.width && dx>0){
            dx = - dx;
        }
        if (y<0 && dy<0){
            dy = Math.abs(dy);
        }
        if (y>GamePanel.height && dy>0){
            dy = - dy;
        }
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int) (x-r), (int) (y-r), 2*r, 2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color.darker());
        g.drawOval((int) (x-r), (int) (y-r), 2*r, 2*r);
        g.setStroke(new BasicStroke(1));
    }
}
