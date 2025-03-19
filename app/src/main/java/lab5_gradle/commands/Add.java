package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;
import lab5_gradle.creators.ProductCreator;

public class Add extends CommandHandler {

    private ProductManager<Product> productCollection;

    public Add(ProductManager<Product> manager) {
        super();
        this.productCollection = manager;
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() {
        return "add {element} : добавить новый элемент в коллекцию";
    }

    @Override
    public String toString() {
        return "add";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        this.productCollection.addProdut(new ProductCreator().createProduct());
        System.out.println("Продукт успешно добавлен в коллекцию");
    }

}
