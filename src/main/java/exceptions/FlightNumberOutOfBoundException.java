package exceptions;

public class FlightNumberOutOfBoundException extends Exception {
    @Override
    public String getMessage() {
        return "flight number should have 3 digits";
    }
}
