import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleGarageTest {

    VehicleWorkshop<Vehicle> vehicleGarage;
    @BeforeEach
    void setUp() {
        vehicleGarage = new VolvoWorkshop(2, 10, 10);
    }

    @Test
    void loadVolvoInVehicleGarage() {
        Volvo240 volvo = new Volvo240();
        assertTrue(vehicleGarage.loadVehicle(volvo));
    }

    @Test
    void loadSaabInVehicleGarage() {
        Saab95 saab95 = new Saab95();
        assertTrue(vehicleGarage.loadVehicle(saab95));
    }

    @Test
    void loadScaniaInVehicleGarage() {
        Scania scania = new Scania();
        assertTrue(vehicleGarage.loadVehicle(scania));
    }

    @Test
    void loadLongTruckInVehicleGarage() {
        LongTruck longTruck = new LongTruck();
        assertTrue(vehicleGarage.loadVehicle(longTruck));
    }

    @Test
    void unloadVehicleInVehicleGarage() {
        Scania scania = new Scania();
        vehicleGarage.loadVehicle(scania);

        assertEquals(scania, vehicleGarage.unloadVehicle(scania));
    }

    @Test
    void testCurrentNrOfVehiclesInGarage() {
        Scania scania = new Scania();
        Volvo240 volvo = new Volvo240();

        vehicleGarage.loadVehicle(scania);
        vehicleGarage.loadVehicle(volvo);

        assertEquals(2, vehicleGarage.getCurrentNrOfVehicle());
    }

    @Test
    void unloadVehicleNotInGarage() {
        Scania scania = new Scania();
        Volvo240 volvo = new Volvo240();

        vehicleGarage.loadVehicle(scania);

        assertThrows(IllegalArgumentException.class,
                () ->{
                    vehicleGarage.unloadVehicle(volvo);
                }
        );
    }



}