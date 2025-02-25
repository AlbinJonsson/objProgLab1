import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    VehicleList vehicleList;

    public void actionPerformed(ActionEvent e){
        for(Vehicle vehicle : vehicleList.getVehicleList()){
            int x = (int) Math.round(vehicle.getCurrentXLocation());
            int y = (int) Math.round(vehicle.getCurrentYLocation());
            frame.drawPanel.moveit(x, y, vehicle);
            //repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

            vehicleList.invertCarIfAtEdge(vehicle);
            vehicleList.parkVolvo();
        }
    }
}
