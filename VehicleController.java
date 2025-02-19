import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of vehicles, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    VehicleGarage<Volvo240> volvoWorkshop = new VehicleGarage<>(3);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        VehicleController cc = new VehicleController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new VehicleView("VehicleSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the vehicles in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getCurrentXLocation());
                int y = (int) Math.round(vehicle.getCurrentYLocation());
                frame.drawPanel.moveit(x, y, vehicle);
                //repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

                invertCarIfAtEdge(vehicle);

                parkVolvo();
            }
        }
    }

    private void invertCarIfAtEdge(Vehicle vehicle) {
        if(isOutOfFrame(vehicle)){
            vehicle.inverDirection();
        }
    }

    private void parkVolvo(){
        for(Vehicle vehicle : vehicles){
            if(!isInRangeOfGarage(vehicle)){
                return;
            }
            if(vehicle instanceof Volvo240){
                vehicle.stopEngine();
                volvoWorkshop.loadVehicle(((Volvo240) vehicle));
            }
        }

    }

    private static boolean isInRangeOfGarage(Vehicle vehicle) {
        return vehicle.getCurrentXLocation() > 285;
    }


    private static boolean isOutOfFrame(Vehicle vehicle) {
        return vehicle.getCurrentXLocation() > 800 || vehicle.getCurrentXLocation() < 0;
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
                ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    void startEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    void stopEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void saabTurboOn(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }

        }
    }

    void saabTurboOff(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }

        }
    }

    void scaniaRaiseRamp(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).raiseRamp();
            }
        }
    }

    void scaniaLowerRamp(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).lowerRamp();
            }
        }
    }
}
