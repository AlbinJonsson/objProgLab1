import java.util.Observer;

public class VehicleModelFacade implements ClickListener{
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


    @Override
    public void gas(int amount) {
        vehicleManager.gas(amount);
    }

    @Override
    public void brake(int amount) {
        vehicleManager.brake(amount);
    }

    @Override
    public void startEngine() {
        vehicleManager.startEngine();
    }

    @Override
    public void stopEngine() {
        vehicleManager.stopEngine();
    }

    @Override
    public void saabTurboOn() {
        vehicleManager.saabTurboOn();
    }

    @Override
    public void saabTurboOff() {
        vehicleManager.saabTurboOff();
    }

    @Override
    public void scaniaRaiseRamp() {
        vehicleManager.scaniaRaiseRamp();
    }

    @Override
    public void scaniaLowerRamp() {
        vehicleManager.scaniaLowerRamp();
    }
}
