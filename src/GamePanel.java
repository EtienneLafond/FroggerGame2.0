import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {

    // Game dimensions
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 600;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    // Frog (player) dimensions
    static final int FROG_WIDTH = 50;
    static final int FROG_HEIGHT = 50;

    // Game components
    Thread gameThread;
    Image image;
    Graphics graphics;
    Frog frog;
    Car car1;
    Car car2;
    Car car3;

    /**
     * Constructor
     * Creates the frog and cars, starts the threat and set panel size.
     */
    GamePanel() {
        newFrog();
        newCar();

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread();
        gameThread.start();
    }

    public void newFrog() {

    }

    public void newCar() {

    }

    public void paint(Graphics g) {

    }

    public void move() {

    }

    public void checkCollision() {

    }

    @Override
    public void run() {

    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
