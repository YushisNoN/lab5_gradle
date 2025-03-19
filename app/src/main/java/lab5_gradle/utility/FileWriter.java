package lab5_gradle.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.interfaces.Writeable;
import lab5_gradle.product.Product;

public class FileWriter extends AbstractFileUse implements Writeable<Product> {

    @Override
    public void write(ProductManager<Product> productManager) throws FileDontExistsException, IOException {
        fileToRead = new File(pathToCurrentDirectory + "\\" + filename);
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(productManager.getCollection());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileToRead);
            fileOutputStream.write(jsonData.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
            fileToRead.setWritable(false);
        } catch (FileDontExistsException e) {
            System.out.println(e.getMessage());
        }
    }

}
