import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ResourceManager {
    private Map<VehicleType, BufferedImage> vehicleImages;

    public ResourceManager() {
        vehicleImages = new HashMap<>();
        loadImages();
    }

    private void loadImages() {
        try {
            vehicleImages.put(VehicleType.SAAB95, ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put(VehicleType.VOLVO240, ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put(VehicleType.WORKSHOP, ImageIO.read(UpdateFrame.class.getResourceAsStream("pics/VolvoBrand.jpg")));
            vehicleImages.put(VehicleType.SCANIA, ImageIO.read(UpdateFrame.class.getResourceAsStream("pics/Scania.jpg")));
            // Lägg till fler bilder här
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(VehicleType vehicleType) {
        return vehicleImages.get(vehicleType);
    }
}
