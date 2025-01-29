import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super("Saab95", Color.red, 0, 125, 2);
	    this.turboOn = false;
        stopEngine();
    }

    public boolean getTurboOnOff(){
        return turboOn;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }else
            throw new IllegalArgumentException("Amount between 0 and 1");
        // try and catch method
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }else
            throw new IllegalArgumentException("Amount between 0 and 1");
    }
}
