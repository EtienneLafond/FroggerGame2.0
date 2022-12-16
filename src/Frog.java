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

    }

    public void draw() {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
