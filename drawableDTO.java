import java.awt.image.BufferedImage;
import java.beans.VetoableChangeListener;

public class drawableDTO {
    private final int x;
    private final int y;
    private final VehicleType vehicleType;

    public drawableDTO(int x, int y, VehicleType vehicleType) {
        this.x = x;
        this.y = y;
        this.vehicleType = vehicleType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
