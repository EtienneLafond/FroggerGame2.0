import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import static org.junit.jupiter.api.Assertions.*;

class FrogTest {

    @Test
    void Frog() {
        Frog frog = new Frog(50, 150);

        assertEquals(500, frog.x);
        assertEquals(500, frog.y);
        assertEquals(50, frog.width);
        assertEquals(150, frog.height);
    }

    @Test
    void move() {
        Frog frog = new Frog(50, 50);
        frog.xVelocity = 50;
        frog.yVelocity = 10;
        frog.move();

        assertEquals(550, frog.x);
        assertEquals(510, frog.y);

        frog.xVelocity = -100;
        frog.yVelocity = -110;
        frog.move();

        assertEquals(450, frog.x);
        assertEquals(400, frog.y);
    }

    @Test
    void draw() {
    }

    @Test
    void keyPressed() {
    }

    @Test
    void keyReleased() {
    }
}