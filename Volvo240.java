import java.awt.*;

// OBS! Brake och Gas metoder ser exakt likadana ut för båda subklasser, Kan vi ha de super klass då??

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super("Volvo240", Color.black, 0, 100, 4);
        stopEngine();
        // varför behöver vi ha metod stopEngine() i konstruktorn?
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    } // abstract klass i Car

    // Behövs det också Override här och nere. Om inte varför?
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor()
                * amount,0);
    }



    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }else
            throw new IllegalArgumentException("Amount between 0 and 1");
    }


    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }else
            throw new IllegalArgumentException("Amount between 0 and 1");
    }
}
