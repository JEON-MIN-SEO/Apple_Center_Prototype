package mate.apple_center_reservation.exception;

public class ReservationCreateException extends RuntimeException {
    public ReservationCreateException(String message) {
        super(message);
    }

    public ReservationCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}