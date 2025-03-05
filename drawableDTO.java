import java.awt.image.BufferedImage;

public class drawableDTO {
    private final int x;
    private final int y;
    private final BufferedImage vehicleImage;

    public drawableDTO(int x, int y, BufferedImage vehicleImage) {
        this.x = x;
        this.y = y;
        this.vehicleImage = vehicleImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getVehicleImage() {
        return vehicleImage;
    }
}
