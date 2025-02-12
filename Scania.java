import java.awt.*;

public class Scania extends Truck {

    private int rampAngle;
    private AngledRamp ramp;

    public Scania() {
        super("Scania", Color.pink, 0, 200, 2);
        stopEngine();
        this.rampAngle = 0;
        this.ramp = new AngledRamp();
    }

    // Raise the ramp
    public void raiseRamp(){
        ramp.raiseRamp(isStandingStill());
    }


    //Down the ramp
    public void lowerRamp(){
        ramp.lowerRamp(isStandingStill());
    }


    // Get the current angle of the ramp
    public int getRampAngle(){
        return ramp.getAngle();
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
