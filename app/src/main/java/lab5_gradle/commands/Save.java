package lab5_gradle.commands;

import java.io.IOException;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.FileWriter;
import lab5_gradle.utility.ProductManager;

public class Save extends CommandHandler {
    private ProductManager<Product> productCollection;

    public Save(ProductManager<Product> manager) {
        super();
        this.productCollection = manager;
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл";
    }

    @Override
    public String toString() {
        return "save";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        FileWriter fileWriter = new FileWriter();
        try {
            fileWriter.write(productCollection);
        } catch (FileDontExistsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
