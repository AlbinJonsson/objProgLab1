import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Car{

    private boolean turboOn;
    private BufferedImage image;
    
    public Saab95(){
        super("Saab95", Color.red, 0, 125, 2);
	    this.turboOn = false;
        stopEngine();
    }

    @Override
    protected void setImage() {
        try{
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BufferedImage getVehicleImage() {
        return image;
    }

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
