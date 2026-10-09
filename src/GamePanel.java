import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
        //Runnable інтерфейс для реалізації багатопоточності
        //BufferedImage клас для роботи з графікою в Java
        //Graphics2D для стаорення двовимірної графіки
        //Thread дозволяє створювати і керувати окремими потоками, які виконуються всередині програми
        private static final  long serialVersionUID = 1L;
        public static int width = 400;
        public static  int height = 400;
        private BufferedImage image;
        private Graphics2D g;
        public Thread thread = new Thread(this);
        public  static GameBack background;
        public static Player player;
        public  static ArrayList<Bullet> bullets;
        public static ArrayList<Enemy> enemies;
        public GamePanel(){
           super();
            setPreferredSize(new Dimension(width, height)); //встановлюєм розміри вікна
            setFocusable(true); // вікно реагує на дії клавіатури
            requestFocus();
            addKeyListener(new Listener());
        }
        public  void  start(){
            thread = new Thread(this);
            thread.start();
        }
        public  void run() {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            background = new GameBack();
            player = new Player();
            enemies = new ArrayList<Enemy>();
            bullets = new ArrayList<Bullet>();
            enemies.add(new Enemy (1,1));
            enemies.add(new Enemy (1,2));
            enemies.add(new Enemy (3,3));
            enemies.add(new Enemy (4,4));
            enemies.add(new Enemy (2,1));
            enemies.add(new Enemy (2,2));
            enemies.add(new Enemy (2, 3));
            enemies.add(new Enemy (2, 4));
            enemies.add(new Enemy (3,2));
            enemies.add(new Enemy (4, 3));
            while (true){
                gameUpdate();
                gameRender();
                gameDraw();
                try {
                    thread.sleep(33);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

        }
public  void gameUpdate(){
                background.draw(g);
                player.update();
                for (int i = 0; i<bullets.size(); i ++){
                        bullets.get(i).update();
                }
        for (int i = 0; i<enemies.size(); i ++){
                enemies.get(i).update();
        }
        for (int i =  0; i<enemies.size(); i++){
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();
            for (int j = 0; j<bullets.size(); j++){
                Bullet b = bullets.get(j);
                double bx = b.getX();
                double by = b.getY();
                double dx = ex-bx;
                double dy = ey-by;
                double dist = Math.sqrt(dx*dx-dy*dy);
                if ( dist<e.getR()+b.getR()){
                    e.hit();
                    bullets.remove(j);
                }
            }
            boolean remove = e.remove();
            if (remove){
                enemies.remove(i);
                i--;
            }
        }

}
public  void  gameRender(){
        background.draw(g);
        player.draw(g);
                for (int i = 0; i< bullets.size(); i++){
                       bullets.get(i).draw((g));

                }
        for (int i = 0; i< enemies.size(); i++){
                enemies.get(i).draw((g));

        }
}
public void  gameDraw(){
                Graphics g2 = this.getGraphics();
                g2.drawImage(image, 0, 0, null);
                g2.dispose();
}

}
