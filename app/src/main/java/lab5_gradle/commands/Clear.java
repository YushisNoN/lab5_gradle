package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public class Clear extends CommandHandler {
    private ProductManager<Product> productManager;

    public Clear(ProductManager<Product> manager) {
        super();
        this.productManager = manager;
    }

    @Override
    public String toString() {
        return "clear";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        if (this.productManager.getCollection().isEmpty()) {
            System.out.println("коллекция пустая :)");
            return;
        }
        this.productManager.getCollection().clear();
        System.out.println("Коллекция успешна очищена >:)");
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "clear : очистить коллекцию";
    }
}
