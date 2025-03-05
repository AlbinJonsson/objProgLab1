import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateFrame extends JPanel implements VehicleObserver {

    private ArrayList<drawableDTO> vehicleData;

    @Override
    public void updateView(ArrayList<drawableDTO> vehicleData) {
        // Uppdatera vehicleData på EDT
        SwingUtilities.invokeLater(() -> {
            this.vehicleData = vehicleData;
            repaint(); // Anropas nu på EDT
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (vehicleData == null) return;
        for(drawableDTO v: vehicleData){
            System.out.println(v.getVehicleImage());
            g.drawImage(v.getVehicleImage(), v.getX(), v.getY(), null);
        }
    }
}
