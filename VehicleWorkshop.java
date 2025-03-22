import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleWorkshop<T extends Vehicle> implements LoadableObject<T> {

    private List<T> vehicles;
    private int capacity;
    private int x;
    private int y;

    public VehicleWorkshop(int capacity, int x, int y) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
        this.x = x;
        this.y = y;
    }

    public int getCurrentNrOfVehicle() {
        return vehicles.size();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public VehicleType getVehicleType(){return VehicleType.WORKSHOP;}

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
            System.out.println("Vehicle unloaded");
            return vehicle;
        }
        throw new IllegalArgumentException("Vehicle not in garage");
    }

}
