import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(VehicleType.SAAB95, Color.red, 0, 125, 2);
	    this.turboOn = false;
        stopEngine();
    }

    @Override
    public VehicleType getVehicleType() {return VehicleType.SAAB95;}

    public boolean getTurboOnOff(){
        return turboOn;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 2;
        return enginePower * 0.01 * turbo;
    }
}
