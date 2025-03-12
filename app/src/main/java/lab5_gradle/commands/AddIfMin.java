package lab5_gradle.commands;

import lab5_gradle.creators.ProductCreator;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.IdGenerator;
import lab5_gradle.utility.ProductManager;

public class AddIfMin extends CommandHandler {
    private ProductManager<Product> productCollection;

    public AddIfMin(ProductManager<Product> manager) {
        super();
        this.productCollection = manager;
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String toString() {
        return "add_if_min";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        Product product = new ProductCreator().createProduct();
        if (this.productCollection.getCollection().first().compareTo(product) > 0) {
            this.productCollection.addProdut(product);
            System.out.println("Продукт успешно добавлен в коллекцию");
            return;
        }
        IdGenerator.updateCounter(this.productCollection.getCollection());
        System.out.println("Элемент невозможно добавить в коллекцию, так как он больше наименьшего элемента ^^");
    }
}
