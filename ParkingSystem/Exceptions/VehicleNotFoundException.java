package ParkingSystem.Exceptions;

public class VehicleNotFoundException extends Throwable {
    public VehicleNotFoundException() {
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
