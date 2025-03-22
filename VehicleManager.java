import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleManager implements ClickListener{

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    VolvoWorkshop volvoWorkshop = new VolvoWorkshop(3, 300, 0);
    ArrayList<VehicleObserver> observers = new ArrayList<>();
    VehicleFactory factory = new VehicleFactory();


    private final int delay = 50;
    private Timer timer = new Timer(delay, new VehicleManager.TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                notifyObservers();

                invertCarIfAtEdge(vehicle);
                parkVolvo();
            }
        }
    }

    private void notifyObservers() {

        ArrayList<drawableDTO> vehicleData = new ArrayList<>();
        int yOffset = 0;

        for (Vehicle vehicle : vehicles) {
            int x = (int) Math.round(vehicle.getX());
            int y = (int) Math.round(vehicle.getY() + yOffset);
            vehicleData.add(new drawableDTO(x, y, vehicle.getVehicleType()));
            yOffset+= 100;
        }
        vehicleData.add(new drawableDTO(volvoWorkshop.getX(), volvoWorkshop.getY(), volvoWorkshop.getVehicleType()));
        for(VehicleObserver observer: observers) {
            observer.updateView(vehicleData);
        }
    }

    public void addObserver(VehicleObserver o) {
        observers.add(o);
    }

    public void removeObserver(VehicleObserver o) {
        observers.remove(o);
    }


    public void startTimer() {
        timer.start();
    }

    private void invertCarIfAtEdge(Vehicle vehicle) {
        if(isOutOfFrame(vehicle)){
            vehicle.invertDirection();
        }
    }
    private void parkVolvo(){
        for(Vehicle vehicle : vehicles){
            if(!isInRangeOfGarage(vehicle)){
                return;
            }
            if(vehicle instanceof Volvo240){
                vehicle.stopEngine();
                volvoWorkshop.loadVehicle((vehicle));
            }
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    private boolean isInRangeOfGarage(Vehicle vehicle) {
        if(!(vehicle.getX() > volvoWorkshop.getX())){
            return false;
        }
        if(volvoWorkshop.getY() >= vehicle.getY() && vehicle.getY() >= volvoWorkshop.getY()){
            return true;
        }
        return false;

    }

    private static boolean isOutOfFrame(Vehicle vehicle) {
        return vehicle.getX() > 800 || vehicle.getX() < 0;
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
            if(vehicle.isStandingStill()){
                vehicle.startEngine();
            }
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

    @Override
    public void addRandomCar() {
        if(vehicles.size() >= 4){return;}
        Vehicle randomVehicle = factory.createRandomVehicle();
        addVehicle(randomVehicle);
    }

    @Override
    public void removeLastAddedCar() {
        if(vehicles.size() <= 0){return;}
        vehicles.removeLast();
    }


}
