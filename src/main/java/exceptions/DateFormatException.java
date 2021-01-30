package exceptions;

public class DateFormatException extends Exception{
    @Override
    public String getMessage() {
        return "Date should enter in the right format";
    }
}
