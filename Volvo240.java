import java.awt.*;


public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super("Volvo240", Color.black, 0, 100, 4);
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    } // abstract klass i Car

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor()
                * amount,0);
    }

}
