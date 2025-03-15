package lab5_gradle;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.NotFileException;
import lab5_gradle.utility.FileReader;
import lab5_gradle.utility.Kernel;

public class App {
    public static void main(String[] args) throws Exception {
        Kernel kernel = new Kernel();
        kernel.setCommands();
        if (args.length == 1) {
            try {
                FileReader.setFileName(args[0]);
            } catch (FileDontExistsException exception) {
                System.out.println(exception.getMessage());
            } catch (NotFileException exception) {
                System.out.println(exception.getMessage());
            }
        }
        kernel.runProgram();
    }
}