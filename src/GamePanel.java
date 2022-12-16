import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

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

    ArrayList<Car> cars = new ArrayList<>();

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

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newFrog() {
        frog = new Frog(FROG_WIDTH, FROG_HEIGHT);
    }

    public void newCar() {
        cars.add(new Car(0, 100, 50, 50, false));
        cars.add(new Car(0, 300, 50, 50, true));
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        frog.draw(g);

        // Draw the cars
        for(Car car : cars) {
            car.draw(g);
        }
    }

    public void move() {
        frog.move();

        // Move the cars
        for(Car car : cars) {
            car.move();
        }
    }

    public void checkCollision() {
        // Check car collision with window edges
        for(Car car : cars) {
            if (!car.hisMovingLeft) {
                // Check car collision with right edge
                if (car.x >= GAME_WIDTH) {
                    car.x = 0;
                }
            } else {
                // Check car collision with left edge
                if (car.x <= 0) {
                    car.x = GAME_WIDTH;
                }
            }
        }

        // Check frog collision with panel edges
        if (frog.x <= 0) {
            frog.x = 0;
        }
        if (frog.x >= GAME_WIDTH-frog.width) {
            frog.x = GAME_WIDTH-frog.width;
        }
        if (frog.y <= 0) {
            frog.y = 0;
        }
        if (frog.y >= GAME_HEIGHT-frog.height) {
            frog.y = GAME_HEIGHT-frog.height;
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        // Game loop
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();;
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            frog.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            frog.keyReleased(e);
        }
    }
}
