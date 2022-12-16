import java.awt.*;

public class Car extends Rectangle {
    // Variables
    int speed;
    boolean hisMovingLeft;

    /**
     * Create a new car based on parameters.
     * @param x - Integer - Starting value of x coordinate.
     * @param y - Integer - Starting value of y coordinate.
     * @param width - Integer - Width of the car.
     * @param height - Integer - Height of the car.
     * @param hisMovingLeft - Boolean - Direction of the car. Right if false, left if true.
     */
    Car(int x, int y, int width, int height, boolean hisMovingLeft) {
        super(x, y, width, height);
        this.speed = 10;
        this.hisMovingLeft = hisMovingLeft;
    }

    /**
     * Update x coordinate of the car based on direction (hisMovingLeft)
     */
    public void move() {
        if (hisMovingLeft) {
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
