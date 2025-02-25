import java.awt.*;
import java.util.ArrayList;

public class VehicleManager implements ClickListener, VehicleList {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    VehicleGarage<Volvo240> volvoWorkshop = new VehicleGarage<>(3);

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    public static void main(String[] args) {
        // Instance of this class
        VehicleManager cc = new VehicleManager();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new VehicleView("VehicleSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    void moveit(int x, int y, Vehicle vehicletype){
        if(vehicletype instanceof Volvo240){
            volvoPoint.x = x;
            volvoPoint.y = y + 50;
        }
        if(vehicletype instanceof Saab95){
            saabPoint.x = x;
            saabPoint.y = y + 150;
        }
        if(vehicletype instanceof Scania){
            scaniaPoint.x = x;
            scaniaPoint.y = y + 250;
        }
    }

    @Override
    public void invertCarIfAtEdge(Vehicle vehicle) {
        if(isOutOfFrame(vehicle)){
            vehicle.invertDirection();
        }
    }

    @Override
    public void parkVolvo(){
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


    @Override
    public ArrayList<Vehicle> getVehicleList() {
        return vehicles;
    }

    @Override
    public void gas(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    @Override
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    @Override
    public void startEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    @Override
    public void stopEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    @Override
    public void saabTurboOn(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }

        }
    }

    @Override
    public void saabTurboOff(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }

        }
    }

    @Override
    public void scaniaRaiseRamp(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).raiseRamp();
            }
        }
    }

    @Override
    public void scaniaLowerRamp(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).lowerRamp();
            }
        }
    }


}
