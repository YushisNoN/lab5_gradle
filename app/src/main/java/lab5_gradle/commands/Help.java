package lab5_gradle.commands;

import java.util.HashMap;

import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.interfaces.Executable;

public class Help extends CommandHandler {
    private HashMap<String, Executable> commandHashMap;

    public Help(HashMap<String, Executable> commandMap) {
        super();
        this.commandHashMap = commandMap;
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException {
        if (arguments.length > this.commandArguments) {
            throw new WrongArgumentsAmountException();
        }
    }

    @Override
    public String toString() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        for (Executable command : this.commandHashMap.values()) {
            try {
                System.out.println(command.getDescription());
            } catch (NullValueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
