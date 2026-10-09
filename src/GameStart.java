import javax.swing.*;

public class GameStart extends JFrame {
    private  static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        JFrame gameStart = new JFrame("My Game");
        GamePanel panel = new GamePanel();
        gameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameStart.setContentPane(panel);
        gameStart.pack();
        gameStart.setLocationRelativeTo(null);
        gameStart.setVisible(true);
        panel.start();
    }
}
