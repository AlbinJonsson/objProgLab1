import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Vehicle implements Movable{
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private VehicleType modelName; // The car model name
    private BufferedImage vehicleImage;

    private Point location;
    private double x;
    private double y;
    private Direction currentDirection;


    public Vehicle(VehicleType modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        this.modelName = modelName;
        this.color = color;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.currentDirection = Direction.EAST;
    }

    public abstract VehicleType getVehicleType();

    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }

    public boolean isStandingStill() {
        return this.currentSpeed == 0;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }



    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount, 0);
    }

    @Override
    public void move() {
        switch (this.currentDirection) {

            case NORTH -> y += this.currentSpeed;
            case WEST -> x -= this.currentSpeed;
            case SOUTH -> y -= this.currentSpeed;
            case EAST -> x += this.currentSpeed;
        }
    }

    @Override
    public void turnLeft(){
        switch (this.currentDirection){
            case NORTH -> this.currentDirection = Direction.WEST;
            case WEST -> this.currentDirection = Direction.SOUTH;
            case SOUTH -> this.currentDirection = Direction.EAST;
            case EAST -> this.currentDirection = Direction.NORTH;
        }
    }

    @Override
    public void turnRight(){
        switch (this.currentDirection){
            case NORTH -> this.currentDirection = Direction.EAST;
            case EAST -> this.currentDirection = Direction.SOUTH;
            case SOUTH -> this.currentDirection = Direction.WEST;
            case WEST -> this.currentDirection = Direction.NORTH;
        }
    }

    protected void gas(double amount){
        if(!isStandingStill()){
            if (0 <= amount && amount <= 1){
                incrementSpeed(amount);
            }else
                throw new IllegalArgumentException("Amount between 0 and 1");
        }

    }


    protected void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }else
            throw new IllegalArgumentException("Amount between 0 and 1");
    }

    void invertDirection(){
        turnLeft();
        turnLeft();
    }
}
