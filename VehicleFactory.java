public class VehicleFactory {
    public Vehicle createVolvo() {
        return new Volvo240();
    }

    public Vehicle createSaab() {
        return new Saab95();
    }

    public Vehicle createScania() {
        return new Scania();
    }
}
