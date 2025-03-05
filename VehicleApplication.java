public class VehicleApplication {


    public static void main(String[] args) {
        // Instance of this class

        VehicleModelFacade facade = new VehicleModelFacade();
        VehicleFactory factory = new VehicleFactory();
        VehicleController controller = new VehicleController(facade);
        FrameView view = new FrameView(controller);
        UpdateFrame updateFrame = new UpdateFrame();


        Vehicle volvo = factory.createVolvo();
        Vehicle saab = factory.createSaab();
        Vehicle scania = factory.createScania();

        facade.addVehicle(volvo);
        facade.addVehicle(saab);
        facade.addVehicle(scania);

        facade.addObserver(updateFrame);

        view.initFrame("Vehicle Simulator", updateFrame);

        // Start the timer
        facade.startTimer();
    }
}
