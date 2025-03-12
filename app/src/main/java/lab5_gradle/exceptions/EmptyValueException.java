package lab5_gradle.exceptions;

public class EmptyValueException extends Exception {
    public EmptyValueException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Значение не может быть пустым";
    }
}
