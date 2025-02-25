import java.util.ArrayList;

public interface VehicleList {
    public ArrayList<Vehicle> getVehicleList();
    public void invertCarIfAtEdge(Vehicle vehicle);
    public void parkVolvo();
}
