import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateFrame extends JPanel implements VehicleObserver {

    private ArrayList<VehicleDTO> vehicleData;

    @Override
    public void updateView(ArrayList<VehicleDTO> vehicleData) {
        // Uppdatera vehicleData på EDT
        SwingUtilities.invokeLater(() -> {
            this.vehicleData = vehicleData;
            repaint(); // Anropas nu på EDT
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(VehicleDTO v: vehicleData){
            g.drawImage(v.getVehicleImage(), v.getX(), v.getY(), null);
        }
    }
}
