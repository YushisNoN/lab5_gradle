package lab5_gradle.commands;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.ReccursionFoundException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.utility.ConsoleHandler;
import lab5_gradle.utility.FileReader;
import lab5_gradle.utility.Kernel;
import java.util.LinkedList;

public class ExecuteScript extends CommandHandler {
    private Kernel kernel;
    private Set<String> finishedScripts = new HashSet<>();

    public ExecuteScript(Kernel kernel) {
        super();
        this.isNeedArguments = true;
        this.commandArguments = 1;
        this.kernel = kernel;
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public void execute(String[] arguments)
            throws WrongArgumentsAmountException, IncorrectStringValueException, IncorrectIntegerValueException {
        if (arguments.length != this.commandArguments) {
            throw new WrongArgumentsAmountException();
        }
        if (arguments[arguments.length - 1].matches("^-?\\d+$") == true) {
            throw new IncorrectStringValueException();
        }
        try {
            FileReader fileReader = new FileReader();
            List<String> commandsList = fileReader.read(arguments[arguments.length - 1]);
            if (this.finishedScripts.contains(arguments[arguments.length - 1])) {
                throw new ReccursionFoundException();
            }
            String input = String.join("\n", commandsList) + "\n";
            InputStream scriptInput = new ByteArrayInputStream(input.getBytes());

            System.out.println(scriptInput);
            InputStream originalInput = System.in;
            System.setIn(scriptInput);
            this.kernel.consoleManager = new ConsoleHandler();
            this.kernel.runProgram();
            // this.kernel.runProgram();
            System.setIn(originalInput);

            // this.kernel.executeCommandsFromScript(commandsList);
            this.finishedScripts.add(arguments[arguments.length - 1]);
        } catch (FileDontExistsException exception) {
            System.out.println(exception.getMessage());
        } catch (ReccursionFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "execute_script";
    }

    @Override
    public String getDescription() throws NullValueException {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

}
