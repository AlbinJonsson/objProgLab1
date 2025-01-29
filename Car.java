import java.awt.*;

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double x;
    private double y;
    private Direction currentDirection;

    private enum Direction {
        NORTH,
        WEST,
        SOUTH,
        EAST
    }


    public Car(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        this.modelName = modelName;
        this.color = color;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.currentDirection = Direction.NORTH;
    }



    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentYLocation(){
        return y;
    }

    public String getCurrentDirection(){
        return currentDirection.toString();
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

    abstract double speedFactor();

    abstract void incrementSpeed(double currentSpeed);

    abstract void decrementSpeed(double currentSpeed);



    public void move() {
        switch (this.currentDirection) {
            case NORTH -> y += this.currentSpeed;
            case WEST -> x -= this.currentSpeed;
            case SOUTH -> y -= this.currentSpeed;
            case EAST -> x += this.currentSpeed;
        }
    }
//        if (this.currentDirection.equals(Direction.NORTH))
//            y+= this.currentSpeed;
//        else if (this.currentDirection.equals(Direction.WEST))
//            x-=this.currentSpeed;
//        else if (this.currentDirection.equals(Direction.SOUTH))
//            y-= this.currentSpeed;
//        else if (this.currentDirection.equals(Direction.EAST))
//            x+= this.currentSpeed;
//    };

    public void turnLeft(){
        switch (this.currentDirection){
            case NORTH -> this.currentDirection = Direction.WEST;
            case WEST -> this.currentDirection = Direction.SOUTH;
            case SOUTH -> this.currentDirection = Direction.EAST;
            case EAST -> this.currentDirection = Direction.NORTH;
        }
//        if (this.currentDirection.equals(Direction.NORTH))
//            this.currentDirection = Direction.WEST;
//        else if (this.currentDirection.equals(Direction.WEST))
//            this.currentDirection = Direction.SOUTH;
//        else if (this.currentDirection.equals(Direction.SOUTH))
//            this.currentDirection = Direction.EAST;
//        else if (this.currentDirection.equals(Direction.EAST))
//            this.currentDirection = Direction.NORTH;
    };

    public void turnRight(){
        switch (this.currentDirection){
            case NORTH -> this.currentDirection = Direction.EAST;
            case EAST -> this.currentDirection = Direction.SOUTH;
            case SOUTH -> this.currentDirection = Direction.WEST;
            case WEST -> this.currentDirection = Direction.NORTH;
        }
//        if (this.currentDirection.equals(Direction.NORTH)){
//            this.currentDirection = Direction.EAST;
//        }else if (this.currentDirection.equals(Direction.EAST)){
//            this.currentDirection = Direction.SOUTH;
//        } else if (this.currentDirection.equals(Direction.SOUTH)) {
//            this.currentDirection = Direction.WEST;
//        } else if (this.currentDirection.equals(Direction.WEST)) {
//            this.currentDirection = Direction.NORTH;
//        }
    };
}
