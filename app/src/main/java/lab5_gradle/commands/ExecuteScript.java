package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;

public class ExecuteScript extends CommandHandler {

    public ExecuteScript() {
        super();
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        System.out.println("какое говнище");
    }

    @Override
    public void execute(String[] arguments)
            throws WrongArgumentsAmountException, IncorrectStringValueException, IncorrectIntegerValueException {
        throw new WrongArgumentsAmountException();
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
