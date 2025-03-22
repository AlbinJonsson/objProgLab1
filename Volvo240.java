import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(VehicleType.VOLVO240, Color.black, 0, 100, 4);
        stopEngine();
    }
    @Override
    public VehicleType getVehicleType() {return VehicleType.VOLVO240;}

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    } // abstract klass i Vehicle

}
