import java.awt.*;
import java.awt.event.KeyEvent;

public class Frog extends Rectangle {
    // Starting position (figure out how to use later)
    final int xStart = GamePanel.GAME_WIDTH/2;
    final int yStart = GamePanel.GAME_HEIGHT-100;

    // Variables
    String name;
    int xVelocity;
    int yVelocity;
    int speed;

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
                yVelocity = speed;
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
                yVelocity = 0;
                break;
        }
    }
}
