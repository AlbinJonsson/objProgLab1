import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class   VolvoTest {

    Volvo240 volvo;

    @BeforeEach
    void setUp() {
        volvo = new Volvo240();
    }

    @Test
    void getNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    void getEnginePower() {

        assertEquals(100, volvo.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {

        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void getColor() {


        assertEquals(Color.BLACK,  volvo.getColor());
    }

    @Test
    void setColor() {

        volvo.setColor(Color.MAGENTA);

        assertEquals(Color.MAGENTA, volvo.getColor());
    }

    @Test
    void startEngine() {

        volvo.startEngine();
        volvo.startEngine();

        assertEquals(0.1, volvo.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        assertEquals(1.25, volvo.speedFactor());
    }

    @Test
    void incrementSpeed() {
        volvo.incrementSpeed(10);
        assertEquals(12.5, volvo.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        volvo.incrementSpeed(10);
        volvo.decrementSpeed(5);

        assertEquals(6.25, volvo.getCurrentSpeed());
    }

    @Test
    void move() {
        volvo.incrementSpeed(10);

        volvo.move();
        volvo.move();
        volvo.move();
        volvo.move();

        assertEquals(50, volvo.getX());


    }

    @Test
    void moveXDirection() {

        volvo.incrementSpeed(10);

        volvo.move();
        volvo.move();
        volvo.move();
        volvo.move();

        assertEquals(50, volvo.getX());


    }

    @Test
    void turnLeft() {

        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();

        assertEquals(Direction.EAST, volvo.getCurrentDirection());
    }

    @Test
    void turnRight() {
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        assertEquals(Direction.WEST, volvo.getCurrentDirection());
    }

    @Test
    void testBrakeWith05(){
        volvo.incrementSpeed(10);
        double previousSpeed = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        double decrementedSpeed = volvo.getCurrentSpeed();

        assertTrue(decrementedSpeed <= previousSpeed);
    }

    @Test
    void brakeWithMoreThan1(){
        assertThrows(IllegalArgumentException.class,
                () ->{
                    volvo.brake(2);
                }
        );
    }
}