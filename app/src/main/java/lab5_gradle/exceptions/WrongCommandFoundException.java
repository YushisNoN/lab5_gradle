package lab5_gradle.exceptions;

public class WrongCommandFoundException extends Exception {
    public WrongCommandFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Неверная команда. Ознакомьтесь со списком команд : help";
    }
}
