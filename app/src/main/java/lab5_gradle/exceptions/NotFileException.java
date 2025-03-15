package lab5_gradle.exceptions;

public class NotFileException extends Exception {
    public NotFileException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Файл невозможно открыть: он является директорией";
    }
}
