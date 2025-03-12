package lab5_gradle.commands;

import lab5_gradle.creators.ProductCreator;
import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.IdGenerator;
import lab5_gradle.utility.ProductManager;

public class UpdateID extends CommandHandler {
    private ProductManager<Product> productManager;

    public UpdateID(ProductManager<Product> manager) {
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
                System.out.println("Для обновления элемента нужно ввести параметры.");
                Product updatedProduct = new ProductCreator().createProduct();
                this.productManager.addProdut(updatedProduct);
                System.out.println("Продукт был успешно обновлён в коллекции");
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
        return "update_id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String toString() {
        return "update_id";
    }
}
