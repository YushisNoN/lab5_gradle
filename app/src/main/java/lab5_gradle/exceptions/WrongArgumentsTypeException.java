package lab5_gradle.exceptions;

public class WrongArgumentsTypeException extends Exception {
    public WrongArgumentsTypeException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Неправильный тип аргументов, передаваемых в метод.";
    }
}
