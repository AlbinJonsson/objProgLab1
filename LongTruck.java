import java.awt.*;

public class LongTruck extends Truck implements LoadableObject<Car> {


    private boolean isRampDown;
    private int currentNrCars;
    private Car[] carsOnTruck;

    public LongTruck() {
        super("Long Hauler", Color.orange, 0, 250, 2);
        this.isRampDown = false;
        this.currentNrCars = 0;
        this.carsOnTruck = new Car[6];
    }


    // Raise the ramp
    @Override
    public void raiseRamp(){
        if(getCurrentSpeed() == 0){
            this.isRampDown = false; // rampen inte nere
        }else
            throw new IllegalArgumentException("Can't raise ramp, current speed: " + getCurrentSpeed());
    }

    //Down the ramp
    @Override
    public void downRamp(){
        if(getCurrentSpeed() == 0){
            this.isRampDown = true; // rampen nere
        }else
            throw new IllegalArgumentException("Can't down ramp, current speed: " + getCurrentSpeed());
    }

    public boolean getIsRampDown(){
        return isRampDown;
    }

    public int getCurrentNrOfCars(){
        return currentNrCars;
    }

    public boolean isCarWithinDistance(Car car){
        double distance = Math.sqrt(Math.pow(car.getCurrentXLocation() - this.getCurrentXLocation(), 2) + Math.pow(car.getCurrentYLocation() - this.getCurrentYLocation(), 2));
        return distance <= 2.0;
    }

    public boolean loadVehicle(Car car){

        if (checkIfCarCanBeLoaded(car)) {
            carsOnTruck[currentNrCars] = car;
            currentNrCars++;
            car.setPosition(this.getCurrentXLocation(), this.getCurrentYLocation());
            car.setLoaded(true);
            return true;
        }else
            return false;
    }


    public Car unloadVehicle(){
        if (checkIfCarCanBeUnloaded()){
            Car car = carsOnTruck[currentNrCars -1];
            carsOnTruck[currentNrCars - 1] = null;
            currentNrCars--;
            car.setLoaded(false);
            car.setPosition(this.getCurrentXLocation() + 4, this.getCurrentYLocation() + 2);
            return car;
        }else {
            return null;
        }

    }


    @Override
    public void move() {
        if (!this.isRampDown){
            super.move();

            for (int i = 0; i < this.currentNrCars; i++) {
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
        if(!isRampDown){
            throw new IllegalArgumentException("Ramp is not down!");
        }
        if (getCurrentSpeed() > 0){
            throw new IllegalArgumentException("The truck is in motion!");
        }
        if(getCurrentNrOfCars() <= 0){
            throw new IllegalArgumentException("No cars to unload!");
        }
        return true;
    }

    private boolean checkIfCarCanBeLoaded(Car car){
        if(!isRampDown){
            throw new IllegalArgumentException("Ramp is not down!");
        }
        if (getCurrentSpeed() > 0){
            throw new IllegalArgumentException("The truck is in motion!");
        }
        if (car.isLoaded){
            throw new IllegalArgumentException("Car is already loaded!");
        }
        if (!isCarWithinDistance(car)){
            throw new IllegalArgumentException("Car is not withing range of the truck!");
        }
        if (!(currentNrCars < carsOnTruck.length)){
            throw new IllegalArgumentException("There are too many cars loaded!");
        }
        return true;
    }
}