import java.awt.*;

public class Car extends Rectangle {
    // Variables
    int speed;
    boolean isMovingLeft;

    /**
     * Create a new car based on parameters.
     * @param x - Integer - Starting value of x coordinate.
     * @param y - Integer - Starting value of y coordinate.
     * @param width - Integer - Width of the car.
     * @param height - Integer - Height of the car.
     * @param isMovingLeft - Boolean - Direction of the car. Right if false, left if true.
     */
    Car(int x, int y, int width, int height, boolean isMovingLeft) {
        super(x, y, width, height);
        this.speed = 10;
        this.isMovingLeft = isMovingLeft;
    }

    /**
     * Update x coordinate of the car based on direction (isMovingLeft)
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
     * Draw the car
     * @param g - the <code>Graphics</code> object to protect.
     */
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}
