import java.awt.*;

public class Vehicle extends Rectangle {
    // Variables
    int speed = 5;
    int width = 20;
    int height = 20;
    boolean isMovingLeft;
    Color color;

    Vehicle() {

    }

    Vehicle(int x, int y, boolean isMovingLeft) {
        this.x = x;
        this.y = y;
        this.isMovingLeft = isMovingLeft;
    }

    public void move() {
        if (isMovingLeft) {
            x -= speed;
        }
        else {
            x += speed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
