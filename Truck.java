import java.awt.*;

public abstract class Truck extends Vehicle {
    public Truck(VehicleType modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
    }
}
