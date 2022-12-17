import java.awt.*;

public class Truck extends Rectangle {
    // Variables
    int speed = 5;
    boolean isMovingLeft;
    Color color = Color.orange;

    /**
     * Create a new truck based on parameters.
     * @param x - Integer - Starting value of x coordinate.
     * @param y - Integer - Starting value of y coordinate.
     * @param width - Integer - Width of the truck.
     * @param height - Integer - Height of the truck.
     * @param isMovingLeft - Boolean - Direction of the truck. Right if false, left if true.
     */
    Truck(int x, int y, int width, int height, boolean isMovingLeft) {
        super(x, y, width, height);
        this.isMovingLeft = isMovingLeft;
    }

    /**
     * Update x coordinate of the truck based on direction (isMovingLeft)
     */
    public void move() {
        if (isMovingLeft) {
            x -= speed;
        }
        else {
            x += speed;
        }
    }

    /**
     * Draw the truck
     * @param g - the <code>Graphics</code> object to protect.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
