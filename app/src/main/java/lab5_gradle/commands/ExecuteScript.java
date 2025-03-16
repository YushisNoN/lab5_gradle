package lab5_gradle.commands;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.utility.ConsoleHandler;
import lab5_gradle.utility.FileReader;

public class ExecuteScript extends CommandHandler {
    private ConsoleHandler consoleHandler;

    public ExecuteScript() {
        super();
        this.isNeedArguments = true;
        this.commandArguments = 1;
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
            String commandsList = String.join("\n", fileReader.read(arguments[arguments.length - 1]));
            InputStream originalInput = System.in;
            ByteArrayInputStream inputStream = new ByteArrayInputStream(commandsList.getBytes());
            System.setIn(inputStream);
            this.consoleHandler = new ConsoleHandler();
            while (this.consoleHandler.getInputStream().hasNextLine()) {
                String line = this.consoleHandler.getInputString();
            }
            System.setIn(originalInput);
        } catch (Exception e) {
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
