import java.awt.*;

public class LongTruck extends Truck implements LoadableObject<Car> {


    private boolean isRampDown;
    private int currentNrCars;
    private Car[] carsOnTruck;

    public LongTruck() {
        super("Long Hauler", Color.orange, 0, 250, 2);
        this.isRampDown = false;
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
    public void raiseRamp(){
        if(getCurrentSpeed() == 0){
            this.isRampDown = false; // rampen inte nere
        }else
            System.out.println("Can't down ramp, current speed: " + getCurrentSpeed());
    }

    //Down the ramp
    public void downRamp(){
        if(getCurrentSpeed() == 0){
            this.isRampDown = true; // rampen nere
        }else
            System.out.println("Can't down ramp, current speed: " + getCurrentSpeed());
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


    public boolean unloadVehicle(){
        if (checkIfCarCanBeUnloaded()){
            Car car = carsOnTruck[currentNrCars -1];
            carsOnTruck[currentNrCars - 1] = null;
            currentNrCars--;
            car.setLoaded(false);
            return true;
        }else {
            return false;
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
            System.out.println("Ramp is not down!");
            return false;
        }
        if (getCurrentSpeed() > 0){
            System.out.println("The truck is in motion!");
            return false;
        }
        if(getCurrentNrOfCars() <= 0){
            System.out.println("No cars to unload!");
            return false;
        }
        return true;
    }

    private boolean checkIfCarCanBeLoaded(Car car){
        if(!isRampDown){
            System.out.println("Ramp is not down!");
            return false;
        }
        if (getCurrentSpeed() > 0){
            System.out.println("The truck is in motion!");
            return false;
        }
        if (car.isLoaded){
            System.out.println("Car is already loaded!");
            return false;
        }
        if (!isCarWithinDistance(car)){
            System.out.println("Car is not withing range of the truck!");
        }
        if (!(currentNrCars < carsOnTruck.length)){
            System.out.println("There are too many cars loaded!");
        }
        return true;
    }
}