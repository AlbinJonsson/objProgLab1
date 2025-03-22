import java.util.Random;

public class VehicleFactory {

    private final Random random = new Random();

    public static Vehicle createVolvo() {
        return new Volvo240();
    }

    public static Vehicle createSaab() {
        return new Saab95();
    }

    public static Vehicle createScania() {
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
