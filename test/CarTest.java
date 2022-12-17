import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    /**
     * Test the Car constructor
     */
    @Test
    void Car() {
        Car car = new Car(10, 20, 30, 40, true);

        assertEquals(10, car.x);
        assertEquals(20, car.y);
        assertEquals(30, car.width);
        assertEquals(40, car.height);
        assertTrue(car.isMovingLeft);
    }

    /**
     * Test the move() method.
     * Testing both ture and false value for isMovingLeft.
     */
    @Test
    void move() {
        Car car = new Car(10, 20, 30, 40, true);
        car.move();
        assertEquals(0, car.x);

        car.isMovingLeft = false;
        car.move();
        assertEquals(10, car.x);
    }

    @Test
    void draw() {

    }
}