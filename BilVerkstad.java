import java.util.ArrayList;
import java.util.List;

public class BilVerkstad<T>  {

    // En idea :) not sure !!

    private Scania scania;
    private Volvo240 volvo240;
    private LongTruck longTruck;   // Komposition av samtliga fordon

    private List<T> cars;
    private int capacity;

    public BilVerkstad(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }





}
