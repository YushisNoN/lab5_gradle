package lab5_gradle.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.interfaces.Writeable;
import lab5_gradle.product.Product;

public class FileWriter extends AbstractFileUse implements Writeable {

    @Override
    public <Product> void write(ProductManager<Product> productManager) throws FileDontExistsException, IOException {
        fileToRead = new File(this.pathToCurrentDirectory + "\\" + filename);
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        String jsonData = gson.toJson(productManager.getCollection());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(
                    this.pathToCurrentDirectory + "\\" + this.filename);
            fileOutputStream.write(jsonData.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileDontExistsException e) {
            System.out.println(e.getMessage());
        }
    }

}
