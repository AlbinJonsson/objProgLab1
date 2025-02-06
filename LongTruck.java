import java.awt.*;

public class LongTruck extends Car {
    // most likely to use composition
    private final Scania scaniaHelper = new Scania(); // Composition
    private boolean ramp;
    private int antalBilar;

    public LongTruck(String modelName, Color color, double currentSpeed, double enginePower, int nrDoors) {
        super(modelName, color, currentSpeed, enginePower, nrDoors);
        this.ramp = false;
        this.antalBilar = 0;
    }

    /*
            Kan man endast använda Scania dvs composition för att få tillgång till
            Car methoder och Scania metoder eller måste man ärva Car?


            funkar instansvariabler för LongTruck på samma sätt som för Scania

            Kan LongTruck använda Car instansvariabler när den skapar en instans av Scania?
     */
    // Raise the ramp
    private void raiseRamp(){
        this.ramp = false; // rampen inte nere
    }

    //Down the ramp
    private void downRamp(){
        this.ramp = true; // rampen ner
    }

    private int getAntalBilar(){
        return antalBilar;
    }

    // Kolla så att bilen som lastas på är inte en transportbil
    // Vad kännetecknar en transportbil dvs hur definierar vi en transportbil
    // De bör då hamna rimligt nära biltransporten. (Ej implementerad)
    // Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades
    //måste vara först att lossas (first-in-last-out). (Ej implementerad)
    // Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara densamma
    // som biltransportens position. (Ej implementerad)


    // Lasta bilar på långtradare
    private void loadCar(){
        if (this.ramp && currentSpeed == 0){
        antalBilar++;
    }else System.out.println("Ramp is not down or Car is in motion!");
    }

    @Override
    public void move() {
        Direction currentDirection = getCurrentDirection();
        if (!this.ramp){
            switch (currentDirection) {
                case NORTH -> y += currentSpeed;
                case WEST -> x -= currentSpeed;
                case SOUTH -> y -= currentSpeed;
                case EAST -> x += currentSpeed;
            }
        }}

    @Override
    double speedFactor() {
        return scaniaHelper.speedFactor();
    }


    @Override
    void incrementSpeed(double currentSpeed) {
        scaniaHelper.incrementSpeed(currentSpeed);
    }

    @Override
    void decrementSpeed(double currentSpeed) {
        scaniaHelper.decrementSpeed(currentSpeed);
    }

    /*private final Scania parent;
    public LongTruck(Scania parent) {
       this.parent = parent;*/


}