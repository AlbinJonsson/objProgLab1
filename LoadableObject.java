public interface LoadableObject<T> {
    boolean loadVehicle(T car);
    boolean unloadVehicle();
}
