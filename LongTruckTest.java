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
    void loadCarOnTruck() {
      Volvo240 volvo = new Volvo240();
      truck.loadCar(volvo);
      assertEquals(1, truck.getCurrentNrOfCars());
    }

    @Test
    void unloadCarOnTruck() {
        Volvo240 volvo = new Volvo240();
        truck.loadCar(volvo);
        truck.unloadCar();
        assertEquals(0, truck.getCurrentNrOfCars());
    }
}