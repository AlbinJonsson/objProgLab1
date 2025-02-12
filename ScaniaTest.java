import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @Test
    void raiseFlak() {
        scania.raiseRamp();
        assertEquals(10, scania.getRampAngle());
    }

    @Test
    void downFlak() {
        scania.raiseRamp();
        scania.raiseRamp();

        scania.downRamp();
        assertEquals(10, scania.getRampAngle());
    }

    @Test
    void getRampAngle() { assertEquals(0, scania.getRampAngle());
    }

    @Test
    void move() {
        scania.incrementSpeed(10);
        scania.move();
        scania.move();
        scania.move();
        scania.move();

        assertEquals(48, scania.getCurrentYLocation());
    }

    @Test
    void downRampWhenAngleIs0(){
        assertThrows(IllegalArgumentException.class,
                () ->{
                    scania.downRamp();
                }
        );
    }

    @Test
    void raiseRampWhenInMotion(){
        scania.incrementSpeed(10);

        assertThrows(IllegalArgumentException.class,
                () ->{
                    scania.raiseRamp();
                }
        );
    }
    @Test
    void downRampWhenInMotion(){
        scania.raiseRamp();
        scania.incrementSpeed(10);

        assertThrows(IllegalArgumentException.class,
                () ->{
                    scania.downRamp();
                }
        );
    }
}