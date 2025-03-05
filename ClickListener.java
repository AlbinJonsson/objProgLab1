public interface ClickListener {
    public void gas(int amount);
    public void brake(int amount);
    public void startEngine();
    public void stopEngine();

    public void saabTurboOn();
    public void saabTurboOff();

    public void scaniaRaiseRamp();
    public void scaniaLowerRamp();

    public void addRandomCar();

    public void removeLastAddedCar();
}
