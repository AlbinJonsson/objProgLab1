import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongTruckTest {

    LongTruck truck;
    @BeforeEach
    void setUp() {
        truck = new LongTruck();
    }

    @Test
    void move() {
        truck.incrementSpeed(10);

        truck.move();
        truck.move();
        truck.move();
        truck.move();

        assertEquals(44, truck.getCurrentYLocation());
    }

    @Test
    void speedFactor() {
        assertEquals(1.1, truck.speedFactor());
    }

    @Test
    void incrementSpeed() {
        truck.incrementSpeed(10);
        assertEquals(11, truck.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        truck.setCurrentSpeed(11);
        truck.decrementSpeed(10);
        assertEquals(0, truck.getCurrentSpeed());
    }

    @Test
    void carOutOfRange() {
        Volvo240 volvo = new Volvo240();
        volvo.incrementSpeed(30);
        volvo.move();
        assertFalse(truck.isCarWithinDistance(volvo));
    }

    @Test
    void carInRange() {
        Volvo240 volvo = new Volvo240();
        assertTrue(truck.isCarWithinDistance(volvo));
    }

    @Test
    void loadVehicleOnTruck() {
      Volvo240 volvo = new Volvo240();

      truck.downRamp();
      truck.loadVehicle(volvo);
      assertEquals(1, truck.getCurrentNrOfCars());
    }

    @Test
    void unloadVehicleOnTruck() {
        Volvo240 volvo = new Volvo240();
        truck.downRamp();
        truck.loadVehicle(volvo);
        truck.unloadVehicle();
        assertEquals(0, truck.getCurrentNrOfCars());
    }

    @Test
    void testCarPositionWhenLoaded(){
        Volvo240 volvo = new Volvo240();
        truck.downRamp();
        truck.loadVehicle(volvo);

        truck.raiseRamp();
        truck.incrementSpeed(10);
        truck.move();
        truck.move();
        truck.move();
        truck.move();

        assertEquals(volvo.getCurrentYLocation(), truck.getCurrentYLocation());
    }

    @Test
    void testRaiseRamp() {
        truck.downRamp();
        truck.raiseRamp();

        assertFalse(truck.getIsRampDown());
    }

    @Test
    void testDownRamp() {

        truck.raiseRamp();
        truck.downRamp();

        assertTrue(truck.getIsRampDown());
    }

    @Test
    void testloadVehicleWhenTruckIsMoving(){
        truck.downRamp();
        Volvo240 volvo = new Volvo240();
        truck.incrementSpeed(10);
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.loadVehicle(volvo);
                }
        );
    }

    @Test
    void testLoadVehicleWhenRampIsRaised(){
        Volvo240 volvo = new Volvo240();
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.loadVehicle(volvo);
                }
        );
    }

    @Test
    void testLoadVehicleWhenVehicleIsAlreadyLoaded(){
        Volvo240 volvo = new Volvo240();
        truck.downRamp();
        truck.loadVehicle(volvo);
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.loadVehicle(volvo);
                }
        );
    }

    @Test
    void testLoadVehicleWhenOutOfRange(){
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(100, 100);

        truck.downRamp();

        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.loadVehicle(volvo);
                }
        );
    }

    @Test
    void testLoadTooManyCars(){
        truck.downRamp();
        Volvo240 volvo = new Volvo240();
        Volvo240 volvo240 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        Volvo240 volvo5 = new Volvo240();
        Volvo240 volvo6 = new Volvo240();
        Volvo240 volvo8 = new Volvo240();

        truck.loadVehicle(volvo);
        truck.loadVehicle(volvo240);
        truck.loadVehicle(volvo3);
        truck.loadVehicle(volvo4);
        truck.loadVehicle(volvo5);
        truck.loadVehicle(volvo6);
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.loadVehicle(volvo8);
                }
        );
    }

    @Test
    void testUnloadCarWhenRampIsRaised(){
        Volvo240 volvo = new Volvo240();
        truck.downRamp();
        truck.loadVehicle(volvo);

        truck.raiseRamp();

        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.unloadVehicle();
                }
        );
    }

    @Test
    void testUnloadCarWhenTruckInMotion(){
        Volvo240 volvo = new Volvo240();
        truck.downRamp();
        truck.loadVehicle(volvo);

        truck.incrementSpeed(10);

        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.unloadVehicle();
                }
        );
    }

    @Test
    void testUnloadCarWhenNoCarsAreLoaded(){
        truck.downRamp();
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.unloadVehicle();
                }
        );
    }

    @Test
    void testRaiseRampWhenTruckIsMoving(){
        truck.incrementSpeed(10);
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.raiseRamp();
                }
        );
    }

    @Test
    void testDownRampWhenTruckIsMoving(){
        truck.incrementSpeed(10);
        assertThrows(IllegalArgumentException.class,
                () ->{
                    truck.downRamp();
                }
        );
    }


}