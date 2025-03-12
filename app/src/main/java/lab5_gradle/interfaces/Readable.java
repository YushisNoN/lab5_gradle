package lab5_gradle.interfaces;

import java.io.IOException;
import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.utility.ProductManager;

public interface Readable {

    public <T> void read(ProductManager<T> productManager) throws FileDontExistsException, IOException;
}
