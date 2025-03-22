import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UpdateFrame extends JPanel implements VehicleObserver {

    private ArrayList<drawableDTO> vehicleData;
    private ResourceManager resourceManager;

    // Konstruktor som tar emot en ResourceManager
    public UpdateFrame(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public void updateView(ArrayList<drawableDTO> vehicleData) {
        this.vehicleData = vehicleData;
        repaint(); // Uppdaterar vyn
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (vehicleData == null) return;

        // Rita varje fordon med hjälp av ResourceManager
        for (drawableDTO v : vehicleData) {
            BufferedImage image = resourceManager.getImage(v.getVehicleType());
            if (image != null) {
                g.drawImage(image, v.getX(), v.getY(), null);
            }
        }
    }
}