package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.utility.Kernel;

public class Exit extends CommandHandler {
    private Kernel kernel;

    public Exit(Kernel kernel) {
        super();
        this.isNeedAllCommands = false;
        this.isNeedCollection = false;
        this.isNeedArguments = false;
        this.kernel = kernel;
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        this.kernel.exitProgram();
    }

    @Override
    public void execute(String[] arguments)
            throws WrongArgumentsAmountException, IncorrectStringValueException, IncorrectIntegerValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "exit : завершить программу (без сохранения в файл)";
    }

    @Override
    public String toString() {
        return "exit";
    }

}
