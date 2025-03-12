package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.IdGenerator;
import lab5_gradle.utility.ProductManager;

public class RemoveByID extends CommandHandler {
    private ProductManager<Product> productManager;

    public RemoveByID(ProductManager<Product> manager) {
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
        long id = Long.parseLong(arguments[arguments.length - 1]);
        for (Product product : this.productManager.getCollection()) {
            if (product.getId() == id) {
                this.productManager.getCollection().remove(product);
                IdGenerator.updateCounter(this.productManager.getCollection());
                System.out.println("Элемент успешно удален из коллекции");
                return;
            }
        }
        System.out.println("Элемента с таким id не существует в коллекции :(");
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

    @Override
    public String toString() {
        return "remove_by_id";
    }
}
