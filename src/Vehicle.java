import java.awt.*;

public class Vehicle extends Rectangle {
    // Variables
    int speed;
    int width;
    int height;
    boolean isMovingLeft;
    Color color;

    Vehicle(int x, int y, int width, int height, boolean isMovingLeft) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
