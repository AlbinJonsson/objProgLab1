import java.awt.*;
import java.sql.Array;

public class LongTruck extends Truck implements LoadableVehicle{


    private boolean rampDown;
    private int currentNrCars;
    private Car[] carsOnTruck;

    public LongTruck() {
        super("Long Hauler", Color.orange, 0, 250, 2);
        this.rampDown = false;
        this.currentNrCars = 0;
        this.carsOnTruck = new Car[8];
    }

    /*
            Kan man endast använda Scania dvs composition för att få tillgång till
            Car methoder och Scania metoder eller måste man ärva Car?


            funkar instansvariabler för LongTruck på samma sätt som för Scania

            Kan LongTruck använda Car instansvariabler när den skapar en instans av Scania?
     */
    // Raise the ramp
    private void raiseRamp(){
        this.rampDown = false; // rampen inte nere
    }

    //Down the ramp
    private void downRamp(){
        this.rampDown = true; // rampen ner
    }
    private boolean getIsRampUp() {
        return rampDown;
    }

    public int getCurrentNrOfCars(){
        return currentNrCars;
    }

    // Kolla så att bilen som lastas på är inte en transportbil
    // Vad kännetecknar en transportbil dvs hur definierar vi en transportbil
    // De bör då hamna rimligt nära biltransporten. (Ej implementerad)
    // Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades
    //måste vara först att lossas (first-in-last-out). (Ej implementerad)
    // Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara densamma
    // som biltransportens position. (Ej implementerad)


    // Lasta bilar på långtradare

    public boolean isCarWithinDistance(Car car){
        double distance = Math.sqrt(Math.pow(car.getCurrentXLocation() - this.getCurrentXLocation(), 2) + Math.pow(car.getCurrentYLocation() - this.getCurrentYLocation(), 2));
        return distance <= 2.0 && !getIsRampUp();
    }

    public boolean loadCar(Car car){
        if (isCarWithinDistance(car) && currentSpeed == 0 && currentNrCars < carsOnTruck.length) {

            carsOnTruck[currentNrCars] = car;
            currentNrCars++;
            car.setPosition(this.getCurrentXLocation(), this.getCurrentYLocation());
            return true;
        }else {
            System.out.println("Ramp is not down, the truck is in motion or there are too many cars loaded already!");
            return false;
        }
    }

    public Car unloadCar(){
        if (currentNrCars > 0){
            Car car = carsOnTruck[currentNrCars -1];
            carsOnTruck[currentNrCars - 1] = null;
            currentNrCars--;
            car.unloadCar();
            return car;
        }else {
            System.out.println("No cars to unload!");
            return null;
        }

    }


    @Override
    public void move() {
        if (!this.rampDown){
            super.move();

            for (int i = 0; i < this.currentNrCars; i++) {
                Car car = carsOnTruck[i];
                if (car != null){
                    car.move();
                }
            }
        }
    }

    @Override
    double speedFactor() {
        return 1.1;
    }




}