import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Truck {

    private int rampAngle;
    private AngledRamp ramp;
    private BufferedImage image;

    public Scania() {
        super("Scania", Color.pink, 0, 200, 2);
        stopEngine();
        this.rampAngle = 0;
        this.ramp = new AngledRamp();
    }

    @Override
    protected void setImage() {
        try{
            image = ImageIO.read(UpdateFrame.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BufferedImage getVehicleImage() {
        return image;
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
