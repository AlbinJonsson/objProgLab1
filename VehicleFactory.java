import java.util.Random;

public class VehicleFactory {

    private final Random random = new Random();

    public Vehicle createVolvo() {
        return new Volvo240();
    }

    public Vehicle createSaab() {
        return new Saab95();
    }

    public Vehicle createScania() {
        return new Scania();
    }

    public Vehicle createRandomVehicle() {
        int choice = random.nextInt(3);

        switch (choice) {
            case 0: return createVolvo();
            case 1: return createSaab();
            case 2: return createScania();
            default: throw new IllegalArgumentException("Invalid vehicle choice." + choice);
        }
    }
}
