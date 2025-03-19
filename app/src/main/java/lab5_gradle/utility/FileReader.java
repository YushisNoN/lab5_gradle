package lab5_gradle.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
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
        try {
            fileToRead = new File(pathToCurrentDirectory + "\\" + filename);
            try (Scanner scanner = new Scanner(fileToRead)) {
                while (scanner.hasNext()) {
                    jsonData += scanner.next();
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            TreeSet<Product> collection = mapper.readValue(jsonData, new TypeReference<TreeSet<Product>>() {
            });
            productManager.setCollection(collection);
            fileToRead.setWritable(true);
        } catch (Exception exception) {
            throw new FileDontExistsException();
        }
    }

    public List<String> read(String filename) {
        try {
            File file = new File(pathToCurrentDirectory + "\\" + filename);
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
            return lines;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;

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
