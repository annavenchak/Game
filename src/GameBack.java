import java.awt.*;

public class GameBack {
    private Color color;
    public GameBack(){
        color = Color.PINK;
    }

    public void  draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0, GamePanel.width, GamePanel.height);
    }

}
