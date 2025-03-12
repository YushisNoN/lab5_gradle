package lab5_gradle.commands;

import lab5_gradle.exceptions.IncorrectStringValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.WrongArgumentsAmountException;
import lab5_gradle.interfaces.Collectable;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public class Info extends CommandHandler implements Collectable {
    private ProductManager<Product> productManager;

    public Info(ProductManager<Product> manager) {
        super();
        this.productManager = manager;

    }

    @Override
    public void execute() throws WrongArgumentsAmountException {
        System.out.println("Информация о коллекции:\n" +
                "Количество элементов: " + this.productManager.getCollection().size() + "\n" +
                "Тип: " + this.productManager.getCollection().getClass().getSimpleName() + "\n" +
                "Время инициализации: " + this.productManager.getInitTime());
    }

    @Override
    public void execute(String[] arguments) throws WrongArgumentsAmountException, IncorrectStringValueException {
        throw new WrongArgumentsAmountException();
    }

    @Override
    public String getDescription() throws NullValueException {
        return "info : Вывести в стандартный поток вывода информацию о коллекции";
    }

    @Override
    public String toString() {
        return "info";
    }

    @Override
    public void setWorkingCollection(ProductManager<Product> productCollection) throws NullValueException {
        this.productManager = productCollection;
    }

    @Override
    public ProductManager<Product> getCollection() {
        return this.productManager;
    }

}
