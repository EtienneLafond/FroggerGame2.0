import java.awt.*;
import java.awt.event.KeyEvent;

public class Frog extends Rectangle {
    // Variables
    String name;
    int xVelocity = 0;
    int yVelocity = 0;
    int speed = 10;

    Frog(int width, int height) {
        super(500, 500, width, height);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }

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
