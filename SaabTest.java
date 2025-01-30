import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SaabTest {

    Saab95 saab95;

    @BeforeEach
    void setUp() {
        saab95 = new Saab95();
    }

    @Test
    void getNrDoors() {
        assertEquals(2, saab95.getNrDoors());
    }

    @Test
    void getEnginePower() {

        assertEquals(125, saab95.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {

        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void getColor() {


        assertEquals(Color.RED,  saab95.getColor());
    }

    @Test
    void setColor() {

        saab95.setColor(Color.BLUE);

        assertEquals(Color.BLUE, saab95.getColor());
    }

    @Test
    void startEngine() {

        saab95.startEngine();
        saab95.startEngine();

        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        saab95.startEngine();
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        assertEquals(1.25, saab95.speedFactor());
    }

    @Test
    void incrementSpeedTurboOff() {
        saab95.incrementSpeed(10);
        assertEquals(12.5, saab95.getCurrentSpeed());
    }

    @Test
    void incrementSpeedTurboOn() {
        saab95.setTurboOn();
        saab95.incrementSpeed(10);
        assertEquals(16.25, saab95.getCurrentSpeed());
    }

    @Test
    void decrementSpeedTurboOff() {
        saab95.incrementSpeed(10);
        saab95.decrementSpeed(5);

        assertEquals(6.25, saab95.getCurrentSpeed());
    }

    @Test
    void decrementSpeedTurboOn() {
        saab95.setTurboOn();
        saab95.incrementSpeed(10);
        saab95.decrementSpeed(5);

        assertEquals(8.125, saab95.getCurrentSpeed());
    }

    @Test
    void moveYDirection() {

        saab95.incrementSpeed(10);

        saab95.move();
        saab95.move();
        saab95.move();
        saab95.move();

        assertEquals(50, saab95.getCurrentYLocation());


    }

    @Test
    void moveXDirection() {

        saab95.turnRight();
        saab95.incrementSpeed(10);

        saab95.move();
        saab95.move();
        saab95.move();
        saab95.move();

        assertEquals(50, saab95.getCurrentXLocation());
    }

    @Test
    void turnLeft() {
        Saab95 saab = new Saab95();

        saab.turnLeft();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.turnLeft();

        assertEquals("NORTH", saab.getCurrentDirection());
    }

    @Test
    void turnRight() {
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        assertEquals("EAST", saab95.getCurrentDirection());
    }

    @Test
    void increaseSpeed(){
        double previousSpeed = saab95.getCurrentSpeed();
        saab95.gas(0.5);
        double incrementedSpeed = saab95.getCurrentSpeed();

        assertTrue(incrementedSpeed > previousSpeed);
    }

    @Test
    void increaseSpeedWithMoreThan1(){
        assertThrows(IllegalArgumentException.class,
                () ->{
                    saab95.gas(2);
                }
                );
    }

    @Test
    void testBrakeWith05(){
        saab95.incrementSpeed(10);
        double previousSpeed = saab95.getCurrentSpeed();
        saab95.brake(0.5);
        double decrementedSpeed = saab95.getCurrentSpeed();

        assertTrue(decrementedSpeed <= previousSpeed);
    }

    @Test
    void brakeWithMoreThan1(){
        assertThrows(IllegalArgumentException.class,
                () ->{
                    saab95.brake(2);
                }
        );
    }

    @Test
    void setTurboOff(){
        saab95.setTurboOn();
        saab95.setTurboOff();

        assertFalse(saab95.getTurboOnOff());
    }

    @Test
    void setTurboOn(){
        saab95.setTurboOn();

        assertTrue(saab95.getTurboOnOff());
    }
}