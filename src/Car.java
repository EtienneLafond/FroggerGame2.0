import java.awt.*;

public class Car extends Vehicle {
    // Variables
    int speed = 10;
    int width = 50;
    int height = 50;
    Color color = Color.white;

    /**
     * Create a new car based on parameters.
     * @param x - Integer - Starting value of x coordinate.
     * @param y - Integer - Starting value of y coordinate.
     * @param width - Integer - Width of the car.
     * @param height - Integer - Height of the car.
     * @param isMovingLeft - Boolean - Direction of the car. Right if false, left if true.
     */
    Car(int x, int y, boolean isMovingLeft) {
        super(x, y, isMovingLeft);
        super.x = x;
        super.y = y;
//        super.width = this.width;
//        super.height = this.height;
        super.speed = speed;
        super.isMovingLeft = isMovingLeft;
        super.color = color;
    }

    /**
     * Update x coordinate of the car based on direction (isMovingLeft)
     */
//    public void move() {
////        if (isMovingLeft) {
////            x -= speed;
////        }
////        else {
////            x += speed;
////        }
//    }

    /**
     * Draw the car
     * @param g - the <code>Graphics</code> object to protect.
     */
//    public void draw(Graphics g) {
//        g.setColor(Color.white);
//        g.fillRect(x, y, width, height);
//    }
}
