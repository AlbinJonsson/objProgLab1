class AngledRamp extends Ramp {
    private int angle;

    @Override
    void raiseRamp(boolean isStandingStill){
        if (canRaiseRamp() && isStandingStill) this.angle+=10;
        else{
            throw new IllegalArgumentException("Cant raise ramp");
        }
    }

    @Override
    void lowerRamp(boolean isStandingStill){
        if (rampCanBeLowered() && isStandingStill) this.angle-=10;
        else{
            throw new IllegalArgumentException("Cant down ramp");
        }
    }

    int getAngle(){return angle;}


    private boolean rampCanBeLowered() {
        return this.getAngle() > 0 && this.getAngle() <= 70;
    }

    private boolean canRaiseRamp() {
        return this.getAngle() >= 0 && this.getAngle() < 70;
    }

}
