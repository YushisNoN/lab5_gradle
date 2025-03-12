package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public class FilterContainsName extends CommandHandler {
    private ProductManager<Product> productManager;

    public FilterContainsName(ProductManager<Product> manager) {
        super();
        this.productManager = manager;
        this.isNeedArguments = true;
        this.commandArguments = 1;
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
        String nameSubString = arguments[arguments.length - 1];
        boolean isNameExists = false;
        for (Product product : this.productManager.getCollection()) {
            if (product.getName().contains(nameSubString)) {
                isNameExists = true;
                System.out.println(product.toString());
            }
        }
        if (false == isNameExists) {
            System.out.println("К сожалению в коллекции нет элементов, чьё имя содержит {" + nameSubString + "}");
        }

    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку";
    }

    @Override
    public String toString() {
        return "filter_contains_name";
    }
}
