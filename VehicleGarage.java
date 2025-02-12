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

    public int getCurrentNrOfVehicle() {
        return currentNrOfVehicle;
    }


    @Override
    public boolean loadVehicle(T vehicle) {
        if(currentNrOfVehicle < capacity){
            this.vehicles.add(vehicle);
            currentNrOfVehicle++;
            return true;
        }

        throw new IllegalArgumentException("The garage is currently full");
    }

    public T unloadVehicle(T vehicle) {
        if (vehicles == null) {
            throw new IllegalArgumentException("vehicles cannot be null");
        }
        if(vehicles.remove(vehicle)){
            vehicles.remove(vehicle);
            System.out.println("Vehicle unloaded");
            return vehicle;
        }
        throw new IllegalArgumentException("Vehicle not in garage");
    }

}
