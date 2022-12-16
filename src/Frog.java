import java.awt.*;
import java.awt.event.KeyEvent;

public class Frog extends Rectangle {
    // Variables
    String name;
    int xVelocity = 0;
    int yVelocity = 0;
    int speed = 10;

    /**
     * Create a new Frog (player) based on parameters
     * @param width - Integer - Width of the frog.
     * @param height - Integer - Height of the frog.
     */
    Frog(int width, int height) {
        super(500, 500, width, height);
    }

    /**
     * Update x and y coordinate of the frog.
     */
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    /**
     * Draw the frog.
     * @param g - the <code>Graphics</code> object to protect.
     */
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }

    /**
     * Check for the key pressed by the player and change the direction of the frog accordingly.
     * @param e - KeyEvent - Key pressed by the player.
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                yVelocity = -speed;
                break;
            case KeyEvent.VK_DOWN:
                yVelocity = speed;
                break;
            case KeyEvent.VK_LEFT:
                xVelocity = -speed;
                break;
            case KeyEvent.VK_RIGHT:
                xVelocity = speed;
                break;
        }
    }

    /**
     * Check for the key released by the player and stop the frog from moving in that direction.
     * @param e - KeyEvent - Key released by the player.
     */
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                yVelocity = 0;
                break;
            case KeyEvent.VK_DOWN:
                yVelocity = 0;
                break;
            case KeyEvent.VK_LEFT:
                xVelocity = 0;
                break;
            case KeyEvent.VK_RIGHT:
                xVelocity = 0;
                break;
        }
    }
}
