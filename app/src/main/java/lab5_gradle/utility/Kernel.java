package lab5_gradle.utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import lab5_gradle.commands.Add;
import lab5_gradle.commands.AddIfMax;
import lab5_gradle.commands.AddIfMin;
import lab5_gradle.commands.Clear;
import lab5_gradle.commands.CountLessThanPrice;
import lab5_gradle.commands.ExecuteScript;
import lab5_gradle.commands.Exit;
import lab5_gradle.commands.FilterContainsName;
import lab5_gradle.commands.Help;
import lab5_gradle.commands.Info;
import lab5_gradle.commands.RemoveAnyByPrice;
import lab5_gradle.commands.RemoveByID;
import lab5_gradle.commands.RemoveGreater;
import lab5_gradle.commands.Save;
import lab5_gradle.commands.Show;
import lab5_gradle.commands.UpdateID;
import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.WrongCommandFoundException;
import lab5_gradle.interfaces.Executable;
import lab5_gradle.product.Product;

public class Kernel {
    private boolean exitProgram = false;
    public ConsoleHandler consoleManager = new ConsoleHandler();
    private CommandManager commandManager = new CommandManager();
    private ProductManager<Product> productManager = new ProductManager<Product>();
    private FileReader fileReader = new FileReader();

    public void exitProgram() {
        this.exitProgram = true;
    }

    public Kernel() {
        try {
            this.fileReader.read(this.productManager);
        } catch (FileDontExistsException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

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
        this.commandManager.addCommand(new Exit(this));
        this.commandManager.addCommand(new ExecuteScript(this));
    }

    public void runProgram() {
        this.consoleManager.printString("-> ");
        while (this.consoleManager.getInputStream().hasNextLine() && false == this.exitProgram) {
            String currentInput = this.consoleManager.getInputString().trim();
            this.executeCommand(currentInput);
            if (this.exitProgram)
                break;
            this.consoleManager.printString("-> ");
        }
    }

    public void executeCommand(String currentInput) {
        String[] currentArguments = Arrays.stream(currentInput.replaceAll("\\s+", " ").trim().split(" "))
                .skip(1).toArray(String[]::new);
        Executable currentCommand = this.commandManager.getCommandsList().get(currentInput.split(" ")[0]);
        try {
            if (null == currentCommand) {
                throw new WrongCommandFoundException();
            } else {
                if (currentCommand.getNeededArguments() || currentArguments.length > 0) {
                    currentCommand.execute(currentArguments);
                    return;
                }
                currentCommand.execute();
            }
        } catch (Exception exception) {
            this.consoleManager.printStringln(exception.getMessage());
        }
    }

    public void executeCommandsFromScript(List<String> commands) {
        for (String command : commands) {
            executeCommand(command);
        }
    }
}
