package lab5_gradle.exceptions;

import java.io.FileNotFoundException;

public class FileDontExistsException extends FileNotFoundException {
    public FileDontExistsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Файл не существует";
    }
}
