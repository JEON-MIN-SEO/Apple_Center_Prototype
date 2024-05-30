package mate.apple_center_reservation.exception;

public class FindException extends RuntimeException {
    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }
}
