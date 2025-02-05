import java.awt.*;

public class LongTruck extends Car {
    // most likely to use composition
    private final Scania scania = new Scania(); // Composition

    public LongTruck(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
    }

    /*
            Kan man endast använda Scania dvs composition för att få tillgång till
            Car methoder och Scania metoder eller måste man ärva Car?


            funkar instansvariabler för LongTruck på samma sätt som för Scania

            Kan LongTruck använda Car instansvariabler när den skapar en instans av Scania?
     */

    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    void incrementSpeed(double currentSpeed) {

    }

    @Override
    void decrementSpeed(double currentSpeed) {

    }

    /*private final Scania parent;
    public LongTruck(Scania parent) {
        this.parent = parent;*/


}