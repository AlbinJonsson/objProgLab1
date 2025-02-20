import java.awt.*;

public class LongTruck extends Truck implements LoadableObject<Car> {

    private Car[] carsOnTruck;
    private ToggleRamp ramp;


    public LongTruck() {
        super("Long Hauler", Color.orange, 0, 250, 2);
        this.carsOnTruck = new Car[6];
        this.ramp = new ToggleRamp();
    }


    public void raiseRamp(){
        ramp.raiseRamp(isStandingStill());
    }

    public void lowerRamp(){
        ramp.lowerRamp(isStandingStill());
    }

    public boolean getIsRampDown(){
        return ramp.getIsRampDown();
    }

    public boolean isCarWithinDistance(Car car){
        double distance = Math.sqrt(Math.pow(car.getCurrentXLocation() - this.getCurrentXLocation(), 2) + Math.pow(car.getCurrentYLocation() - this.getCurrentYLocation(), 2));
        return distance <= 2.0;
    }

    public boolean loadVehicle(Car car){

        if (checkIfCarCanBeLoaded(car)) {
            carsOnTruck[getCurrentNrCars()] = car;
            car.setPosition(this.getCurrentXLocation(), this.getCurrentYLocation());
            car.setLoaded(true);
            return true;
        }else
            return false;
    }


    public Car unloadVehicle(){
        if (checkIfCarCanBeUnloaded()){
            Car car = carsOnTruck[getCurrentNrCars() -1];
            carsOnTruck[getCurrentNrCars() - 1] = null;
            car.setLoaded(false);
            car.setPosition(this.getCurrentXLocation() + 4, this.getCurrentYLocation() + 2);
            return car;
        }else {
            return null;
        }

    }


    @Override
    public void move() {
        if (!ramp.getIsRampDown()) {
            super.move();

            for (int i = 0; i < getCurrentNrCars(); i++) {
                Car car = carsOnTruck[i];
                if (car != null){
                    car.setPosition(this.getCurrentXLocation(), this.getCurrentYLocation());
                }
            }
        }
    }

    @Override
    double speedFactor() {
        return 1.1;
    }

    private boolean checkIfCarCanBeUnloaded(){
        if(!ramp.getIsRampDown()){
            throw new IllegalArgumentException("Ramp is not down!");
        }
        if (getCurrentSpeed() > 0){
            throw new IllegalArgumentException("The truck is in motion!");
        }
        if(getCurrentNrCars() <= 0){
            throw new IllegalArgumentException("No cars to unload!");
        }
        return true;
    }

    public int getCurrentNrCars(){
        int count = 0;
        for(Car car : carsOnTruck){
            if(car != null){
                count++;
            }
        }
        return count;
    }

    private boolean checkIfCarCanBeLoaded(Car car){
        if(!ramp.getIsRampDown()){
            throw new IllegalArgumentException("Ramp is not down!");
        }
        if (getCurrentSpeed() > 0){
            throw new IllegalArgumentException("The truck is in motion!");
        }
        if (car.getIsLoaded()){
            throw new IllegalArgumentException("Car is already loaded!");
        }
        if (!isCarWithinDistance(car)){
            throw new IllegalArgumentException("Car is not withing range of the truck!");
        }
        if (!(getCurrentNrCars() < carsOnTruck.length)){
            throw new IllegalArgumentException("There are too many cars loaded!");
        }
        return true;
    }
}