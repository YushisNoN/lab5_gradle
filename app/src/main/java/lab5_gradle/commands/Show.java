package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public class Show extends CommandHandler {
    private ProductManager<Product> productManager;

    public Show(ProductManager<Product> manager) {
        super();
        this.productManager = manager;
    }

    @Override
    public String toString() {
        return "show";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        if (this.productManager.getCollection().isEmpty()) {
            System.out.println("коллекция пустая :(");
            return;
        }
        for (Product product : this.productManager.getCollection()) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

}
