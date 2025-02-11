import java.awt.*;

public abstract class Car extends Vehicle{

    protected boolean isLoaded;
    private LoadableVehicle loadableVehicle;

    public Car(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
    }

    protected void setLoaded(boolean loaded) {
        this.isLoaded = loaded;
    }

    @Override
    public void move() {
        if(!this.isLoaded) {
            super.move();
        }
    }



}
