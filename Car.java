import java.awt.*;

public abstract class Car {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public Car(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        this.modelName = modelName;
        this.color = color;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
    }



    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return 2;
    }

    abstract void incrementSpeed(double currentSpeed);

    abstract void decrementSpeed(double currentSpeed);
}
