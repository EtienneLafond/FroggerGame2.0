import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest {

    /**
     * Test the GamePanel constructor.
     * Check the panel config.
     * Check the frog size and location.
     * Check that the cars ArrayList<Car> has 2 entries.
     */
    @Test
    void GamePanel() {
        GamePanel panel = new GamePanel();
        Dimension size = new Dimension(1000, 600);

        // Panel
        assertEquals(size, panel.getPreferredSize());
        assertTrue(panel.isFocusable());
        assertTrue(panel.gameThread.isAlive());
        assertTrue(panel.running);

        // Frog
        assertEquals(500, panel.frog.x);
        assertEquals(500, panel.frog.y);
        assertEquals(50, panel.frog.width);
        assertEquals(50, panel.frog.height);

        // Car
        assertEquals(2, panel.cars.size());
    }

    /**
     * Test the newFrog() method.
     * Check the frog size and location.
     */
    @Test
    void newFrog() {
        GamePanel panel = new GamePanel();
        panel.newFrog();

        assertEquals(500, panel.frog.x);
        assertEquals(500, panel.frog.y);
        assertEquals(50, panel.frog.width);
        assertEquals(50, panel.frog.height);
    }

    /**
     * Test the newCar() method.
     * Check both cars that should be created.
     */
    @Test
    void newCar() {
        GamePanel panel = new GamePanel();
        panel.newCar();

        assertEquals(0, panel.cars.get(0).x);
        assertEquals(100, panel.cars.get(0).y);
        assertEquals(50, panel.cars.get(0).width);
        assertEquals(50, panel.cars.get(0).height);
        assertEquals(10, panel.cars.get(0).speed);
        assertFalse(panel.cars.get(0).isMovingLeft);

        assertEquals(0, panel.cars.get(1).x);
        assertEquals(300, panel.cars.get(1).y);
        assertEquals(50, panel.cars.get(1).width);
        assertEquals(50, panel.cars.get(1).height);
        assertEquals(10, panel.cars.get(1).speed);
        assertTrue(panel.cars.get(1).isMovingLeft);
    }

    @Test
    void paint() {
    }

    @Test
    void draw() {
    }

    @Test
    void move() {
    }

    @Test
    void checkCollision() {
    }

    @Test
    void run() {
    }
}