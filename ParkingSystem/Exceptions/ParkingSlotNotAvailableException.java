package ParkingSystem.Exceptions;

public class ParkingSlotNotAvailableException extends Throwable {
    public ParkingSlotNotAvailableException() {
    }

    public ParkingSlotNotAvailableException(String message) {
        super(message);
    }
}
