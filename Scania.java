import java.awt.*;

public class Scania extends Car {

    private final Volvo240 helper = new Volvo240();  // Composition
    private Volvo240 volvo;  // composition
    private int flakAngle;


    public Scania() {
        super("Scania", Color.pink, 0, 200, 2);
        stopEngine();
        this.flakAngle = 0;
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
        return helper.speedFactor();
    }

    @Override
    void incrementSpeed(double currentSpeed) {
        helper.incrementSpeed(currentSpeed);
    }

    @Override
    void decrementSpeed(double currentSpeed) {
        helper.decrementSpeed(currentSpeed);
    }
}
