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

    // Text constants
    Color gameOverColor = Color.red;
    Color gameWonColor = Color.green;

    // Game components
    boolean running;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Frog frog;
    ArrayList<Car> cars = new ArrayList<>();

    /**
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
        running = true;
    }

    /**
     * Creates new Frog (player).
     */
    public void newFrog() {
        frog = new Frog(FROG_WIDTH, FROG_HEIGHT);
    }

    /**
     * Creates new cars and add them to ArrayList<> cars.
     */
    public void newCar() {
        cars.add(new Car(0, 100, 50, 50, false));
        cars.add(new Car(0, 300, 50, 50, true));
    }

    /**
     * Paints the components on the game panel.
     * @param g - the <code>Graphics</code> object to protect.
     */
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Draw the frog and cars when the game is running.
     * Draw Game Over when the player loses.
     * @param g - the <code>Graphics</code> object to protect.
     */
    public void draw(Graphics g) {
        if (running) {
            frog.draw(g);

            // Draw the cars
            for (Car car : cars) {
                car.draw(g);
            }
        } else {
            if (frog.y <= 0) {
                gameWon(g);
            } else {
                gameOver(g);
            }
        }
    }

    /**
     * Move the frog (player) and each car.
     */
    public void move() {
        frog.move();

        // Move the cars
        for(Car car : cars) {
            car.move();
        }
    }

    /**
     * Check for collisions between:
     *  - frog and window edges
     *  - cars and window edges
     *  - frog and cars
     */
    public void checkCollision() {
        // Check car collision with window edges
        for(Car car : cars) {
            if (!car.isMovingLeft) {
                // Check car collision with right edge
                if (car.x >= GAME_WIDTH) {
                    car.x = 0-car.width;
                }
            } else {
                // Check car collision with left edge
                if (car.x <= 0-car.width) {
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
            running = false;
        }
        if (frog.y >= GAME_HEIGHT-frog.height) {
            frog.y = GAME_HEIGHT-frog.height;
        }

        // Check collision between the frog and cars
        for(Car car : cars) {
            if (frog.intersects(car)) {
                running = false;
            }
        }
    }

    /**
     *
     */
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        // Game loop
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Print "Game Over" message on the screed
     * @param g - the <code>Graphics</code> object to protect
     */
    public void gameOver(Graphics g) {
        // Game Over text
        g.setColor(gameOverColor);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metric1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_SIZE.width - metric1.stringWidth("Game Over"))/2,
                SCREEN_SIZE.height/2);
    }

    /**
     * Print "You Won!" message on the screen
     * @param g - the <code>Graphics</code> object to protect
     */
    public void gameWon(Graphics g) {
        // Game Over text
        g.setColor(gameWonColor);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metric1 = getFontMetrics(g.getFont());
        g.drawString("You Won!", (SCREEN_SIZE.width - metric1.stringWidth("You Won!"))/2,
                SCREEN_SIZE.height/2);
    }

    /**
     * Check for the key pressed/released by the player and change the direction of the frog accordingly.
     */
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            frog.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            frog.keyReleased(e);
        }
    }
}
