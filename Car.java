import java.awt.*;

public abstract class Car extends Vehicle{

    private boolean isLoaded;

    public Car(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
    }

    public void setLoaded(boolean loaded) {
        this.isLoaded = loaded;
    }

    public boolean getIsLoaded() {
        return isLoaded;
    }

    @Override
    public void move() {
        if(!this.isLoaded) {
            super.move();
        }
    }



}
