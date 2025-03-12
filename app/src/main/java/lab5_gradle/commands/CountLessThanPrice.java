package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public class CountLessThanPrice extends CommandHandler {
    private ProductManager<Product> productManager;

    public CountLessThanPrice(ProductManager<Product> manager) {
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
        if (arguments[arguments.length - 1].matches("^-?\\d+$") == false) {
            throw new IncorrectIntegerValueException();
        }
        int elementsCounter = 0;
        int priceToCount = Integer.parseInt(arguments[arguments.length - 1]);
        for (Product product : this.productManager.getCollection()) {
            if (product.getPrice() < priceToCount) {
                elementsCounter++;
            }
        }
        if (elementsCounter > 0) {
            System.out.println("В коллекции " + elementsCounter + "Элементов, цена которых меньше чем " + priceToCount);
        } else {
            System.out.println("В коллекции нет элементов, у которых цена меньше " + priceToCount);
        }
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "count_less_than_price price : вывести количество элементов, значение поля price которых меньше заданного";
    }

    @Override
    public String toString() {
        return "count_less_than_price";
    }
}
