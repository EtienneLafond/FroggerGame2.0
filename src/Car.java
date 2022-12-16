import java.awt.*;

public class Car extends Rectangle {
    // Variables
    int speed;
    boolean direction;


    Car(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.speed = 10;
        this.direction = true;
    }

    public void move() {
        x += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}
