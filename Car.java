import java.awt.*;

public abstract class Car extends Vehicle{

    private boolean isLoaded;
    private LoadableVehicle loadableVehicle;

    public Car(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
    }

    public void load(LoadableVehicle vehicle) {
        if(vehicle.loadCar(this)&& !this.isLoaded) {
            this.isLoaded = true;
            this.loadableVehicle = vehicle;
        }
    }

    public void unloadCar(){
        if (this.isLoaded) {
            this.loadableVehicle.unloadCar();
            this.isLoaded = false;
            this.loadableVehicle = null;
        }
    }



}
