import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleGarage<T extends Vehicle> implements LoadableObject<T> {

    private List<T> vehicles;
    private int capacity;
    private BufferedImage workshopImage;
    private int x;
    private int y;

    public VehicleGarage(int capacity, int x, int y) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
        this.x = x;
        this.y = y;
        setImage();
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

    private void setImage(){
        try{
            workshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getWorkshopImage(){return workshopImage;}

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
