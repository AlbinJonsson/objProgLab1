import java.util.ArrayList;
import java.util.List;

public class VehicleGarage<T extends Vehicle> implements LoadableObject<T> {

    private List<T> vehicles;
    private int capacity;
    private int currentNrOfVehicle;

    public VehicleGarage(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }


    @Override
    public boolean loadVehicle(T vehicle) {
        if(currentNrOfVehicle < capacity){
            this.vehicles.add(vehicle);
            currentNrOfVehicle++;
            return true;
        }
        return false;
    }

    @Override
    public boolean unloadVehicle() {
        return false;
    }

}
