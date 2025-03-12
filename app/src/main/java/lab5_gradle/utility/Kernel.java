package lab5_gradle.utility;

import java.util.Arrays;

import lab5_gradle.commands.Add;
import lab5_gradle.commands.AddIfMax;
import lab5_gradle.commands.AddIfMin;
import lab5_gradle.commands.Clear;
import lab5_gradle.commands.CountLessThanPrice;
import lab5_gradle.commands.FilterContainsName;
import lab5_gradle.commands.Help;
import lab5_gradle.commands.Info;
import lab5_gradle.commands.RemoveAnyByPrice;
import lab5_gradle.commands.RemoveByID;
import lab5_gradle.commands.RemoveGreater;
import lab5_gradle.commands.Save;
import lab5_gradle.commands.Show;
import lab5_gradle.commands.UpdateID;
import lab5_gradle.exceptions.WrongCommandFoundException;
import lab5_gradle.interfaces.Executable;
import lab5_gradle.product.Product;

public class Kernel {
    private boolean exitProgram = false;
    private ConsoleHandler consoleManager = new ConsoleHandler();
    private CommandManager commandManager = new CommandManager();
    private ProductManager<Product> productManager = new ProductManager<Product>();

    public void setCommands() {
        this.commandManager.addCommand(new Help(this.commandManager.getCommandsList()));
        this.commandManager.addCommand(new Add(this.productManager));
        this.commandManager.addCommand(new Info(this.productManager));
        this.commandManager.addCommand(new Show(this.productManager));
        this.commandManager.addCommand(new Clear(this.productManager));
        this.commandManager.addCommand(new UpdateID(this.productManager));
        this.commandManager.addCommand(new RemoveByID(this.productManager));
        this.commandManager.addCommand(new AddIfMax(this.productManager));
        this.commandManager.addCommand(new AddIfMin(this.productManager));
        this.commandManager.addCommand(new RemoveGreater(this.productManager));
        this.commandManager.addCommand(new CountLessThanPrice(this.productManager));
        this.commandManager.addCommand(new FilterContainsName(this.productManager));
        this.commandManager.addCommand(new RemoveAnyByPrice(this.productManager));
        this.commandManager.addCommand(new Save(this.productManager));
    }

    public void runProgram() {
        while (this.consoleManager.getInputStream().hasNextLine() && false == this.exitProgram) {
            String currentInput = this.consoleManager.getInputString();
            String[] currentArguments = Arrays.copyOfRange(currentInput.split(" "), 1, currentInput.split(" ").length);
            Executable currentCommand = this.commandManager.getCommandsList().get(currentInput.split(" ")[0]);
            try {
                if (null == currentCommand) {
                    throw new WrongCommandFoundException();
                } else {
                    if (currentCommand.getNeededArguments()) {
                        currentCommand.execute(currentArguments);
                        continue;
                    }
                    currentCommand.execute();
                }
            } catch (Exception exception) {
                this.consoleManager.printString(exception.getMessage());
            }
        }
    }
}
