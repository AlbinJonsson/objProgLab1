import java.awt.*;

public class Scania extends Truck {

    private int rampAngle;


    public Scania() {
        super("Scania", Color.pink, 0, 200, 2);
        stopEngine();
        this.rampAngle = 0;
    }

    // Raise the ramp
    public void raiseRamp(){
        if (this.rampAngle >= 0 && this.rampAngle <70 && isStandingStill()) this.rampAngle+=10;
        else{
            throw new IllegalArgumentException("Cant raise ramp");
        }
    }

    //Down the ramp
    public void downRamp(){
        if (rampCanBeLowered() && isStandingStill()) this.rampAngle-=10;
        else{
            throw new IllegalArgumentException("Cant down ramp");
        }
    }

    private boolean isStandingStill() {
        return this.currentSpeed == 0;
    }

    private boolean rampCanBeLowered() {
        return this.getRampAngle() > 0 && this.getRampAngle() <= 70;
    }

    // Get the current position of the flak
    public double getRampAngle(){
        return this.rampAngle;
    }


    @Override
    public void move() {
        if (this.rampAngle == 0){
            super.move();
        }
    }

    @Override
    double speedFactor() {
        return 1.2;
    }

}
