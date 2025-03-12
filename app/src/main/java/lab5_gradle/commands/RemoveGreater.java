package lab5_gradle.commands;

import lab5_gradle.creators.ProductCreator;
import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.IdGenerator;
import lab5_gradle.utility.ProductManager;

public class RemoveGreater extends CommandHandler {
    private ProductManager<Product> productCollection;

    public RemoveGreater(ProductManager<Product> manager) {
        super();
        this.productCollection = manager;
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() {
        return "remove_greater {element} : удалить из коллекции все элементы, превыщающие заданный.";
    }

    @Override
    public String toString() {
        return "remove_greater";
    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        Product product = new ProductCreator().createProduct();
        int sizeOld = this.productCollection.getCollection().size();
        this.productCollection.getCollection()
                .removeAll(this.productCollection.getCollection().tailSet(product, false));
        int sizeNew = this.productCollection.getCollection().size();
        IdGenerator.updateCounter(this.productCollection.getCollection());
        System.out.println("Из коллекции успешно удалено " + (sizeOld - sizeNew) + " Элементов");
    }
}
