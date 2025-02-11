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
    void testloadVehicleWhenTruckIsMoving(){
        Volvo240 volvo = new Volvo240();
        truck.incrementSpeed(10);
        truck.loadVehicle(volvo);
    }

    @Test
    void loadMaxNumberOfCars(){

        truck.downRamp();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        Volvo240 volvo3 = new Volvo240();
        Volvo240 volvo4 = new Volvo240();
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Saab95 saab3 = new Saab95();
        Saab95 saab5 = new Saab95();
        Saab95 saab6 = new Saab95();

        truck.loadVehicle(volvo1);
        truck.loadVehicle(volvo2);
        truck.loadVehicle(volvo3);
        truck.loadVehicle(volvo4);
        truck.loadVehicle(saab1);
        truck.loadVehicle(saab2);
        truck.loadVehicle(saab3);
        truck.loadVehicle(saab5);

        assertEquals(8, truck.getCurrentNrOfCars());
    }

    @Test
    void BilVerkstad(){

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        VehicleGarage<Truck> allaFordon = new VehicleGarage<>(10);


        allaFordon.loadVehicle(scania);

    }


}