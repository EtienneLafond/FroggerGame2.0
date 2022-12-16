import java.awt.*;

public class Car extends Rectangle {
    // Variables
    int speed;
    boolean hisMovingLeft;


    Car(int x, int y, int width, int height, boolean hisMovingLeft) {
        super(x, y, width, height);
        this.speed = 10;
        this.hisMovingLeft = hisMovingLeft;
    }

    public void move() {
        if (hisMovingLeft) {
            x -= speed;
        }
        else {
            x += speed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}
