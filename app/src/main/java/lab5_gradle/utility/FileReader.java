package lab5_gradle.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import javax.lang.model.type.ReferenceType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.NotFileException;
import lab5_gradle.interfaces.Readable;
import lab5_gradle.product.Product;

public class FileReader extends AbstractFileUse implements Readable<Product> {
    @Override
    public void read(ProductManager<Product> productManager) throws FileDontExistsException, IOException {
        String jsonData = "";
        fileToRead = new File(pathToCurrentDirectory + "\\" + filename);
        try (Scanner scanner = new Scanner(fileToRead)) {
            while (scanner.hasNext()) {
                jsonData += scanner.next();
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        TreeSet<Product> collection = mapper.readValue(fileToRead, new TypeReference<TreeSet<Product>>() {
        });
        productManager.setCollection(collection);
    }

    public static void setFileName(String fileName) throws FileDontExistsException, NotFileException {
        fileToRead = new File(pathToCurrentDirectory + "\\" + fileName);
        if (false == fileToRead.exists()) {
            throw new FileDontExistsException();
        }
        if (false == fileToRead.isFile()) {
            throw new NotFileException();
        }
        filename = fileName;
    }
}
