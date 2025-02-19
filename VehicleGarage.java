import java.util.ArrayList;
import java.util.List;

public class VehicleGarage<T extends Vehicle> implements LoadableObject<T> {

    private List<T> vehicles;
    private int capacity;

    public VehicleGarage(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }

    public int getCurrentNrOfVehicle() {
        return vehicles.size();
    }


    @Override
    public boolean loadVehicle(T vehicle) {
        if(vehicles.contains(vehicle))
            return false;

        if(getCurrentNrOfVehicle() < capacity){
            this.vehicles.add(vehicle);
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
