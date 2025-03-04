import java.util.Observer;

public class VehicleModelFacade {
    private final VehicleManager vehicleManager;

    public VehicleModelFacade() {
        this.vehicleManager = new VehicleManager();
    }

    public void startTimer(){
        vehicleManager.startTimer();
    }

    public void addVehicle(Vehicle vehicle){
        vehicleManager.addVehicle(vehicle);
    }

    public void addObserver(VehicleObserver observer){
        vehicleManager.addObserver(observer);
    }

    public void removeObserver(VehicleObserver observer){
        vehicleManager.removeObserver(observer);
    }



}
