package lab5_gradle.interfaces;

import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.product.Product;
import lab5_gradle.utility.ProductManager;

public interface Collectable {
    public void setWorkingCollection(ProductManager<Product> productCollection) throws NullValueException;

    public ProductManager<Product> getCollection();
}
