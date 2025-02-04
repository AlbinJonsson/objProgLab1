import java.awt.*;

public class Scania extends Car {

    private int flakAngle;
    private int speed;

    public Scania() {
        super("Scania", Color.pink, 0, 200, 2);
        stopEngine();
        this.flakAngle = 0;
        this.speed = 0;
    }

    // Raise the flak
    public void raiseFlak(){
        if (this.flakAngle >= 0 && this.flakAngle <=70 && this.currentSpeed == 0) this.flakAngle++;
    }

    //Down the falk
    public void downFlak(){
        if (this.flakAngle >= 0 && this.flakAngle <=70 && this.currentSpeed == 0) this.flakAngle--;
    }

    // Get the current position of the flak
    public double getFlakAngle(){
        return this.flakAngle;
    }


    @Override
    public void move() {
        Direction currentDirection = getCurrentDirection();
        if (this.flakAngle == 0){
        switch (currentDirection) {
            case NORTH -> y += currentSpeed;
            case WEST -> x -= currentSpeed;
            case SOUTH -> y -= currentSpeed;
            case EAST -> x += currentSpeed;
        }
    }}

    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    void incrementSpeed(double currentSpeed) {

    }

    @Override
    void decrementSpeed(double currentSpeed) {

    }
}
