package lab5_gradle.utility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.interfaces.Readable;

public class FileReader extends AbstractFileUse implements Readable {
    @Override
    public <Product> void read(ProductManager<Product> productManager) throws FileDontExistsException, IOException {
        TreeSet<Product> collection = new TreeSet<>();
        String jsonData = null;
        fileToRead = new File(this.pathToCurrentDirectory + "\\" + filename);
        try (Scanner scanner = new Scanner(fileToRead)) {
            while (scanner.hasNext()) {
                jsonData += scanner.next();
            }
        }
        Gson gson = new Gson();
        Type type = new TypeToken<TreeSet<Product>>() {
        }.getType();
        collection = gson.fromJson(jsonData, type);
        productManager.setCollection(collection);
    }

    public static void setFileName(String fileName) {
        filename = fileName;
    }

}
