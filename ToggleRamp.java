class ToggleRamp extends Ramp {
    private boolean isRampDown = false;


    @Override
    void raiseRamp(boolean isStandingStill) {
        if(isStandingStill){
            this.isRampDown = false; // rampen inte nere
        }else
            throw new IllegalArgumentException("Can't raise the ramp, the truck is in motion");
    }

    @Override
    void lowerRamp(boolean isStandingStill) {
        if(isStandingStill){
            this.isRampDown = true; // rampen nere
        }else
            throw new IllegalArgumentException("Can't lower the ramp, the truck is in motion");
    }

    boolean getIsRampDown() {return isRampDown;}
}

