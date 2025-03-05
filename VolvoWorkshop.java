import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VolvoWorkshop extends VehicleWorkshop {

    private BufferedImage volvoWorkshopImage;

    public VolvoWorkshop(int capacity, int x, int y) {
        super(capacity, x, y);
    }

    @Override
    protected void setImage(){
        try{
            volvoWorkshopImage = ImageIO.read(UpdateFrame.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BufferedImage getWorkshopImage(){
        return volvoWorkshopImage;
    }
}
