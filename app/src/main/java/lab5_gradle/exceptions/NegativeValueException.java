package lab5_gradle.exceptions;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Значение не может быть меньше нуля";
    }
}
