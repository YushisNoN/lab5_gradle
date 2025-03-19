package lab5_gradle.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lab5_gradle.exceptions.FileDontExistsException;
import lab5_gradle.exceptions.NotFileException;
import lab5_gradle.interfaces.Readable;
import lab5_gradle.product.Product;

public class FileReader extends AbstractFileUse implements Readable<Product> {

    private boolean isValidate = true;

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
            for (Product product : collection) {
                validate(product);
            }
            if (isValidate) {
                productManager.setCollection(collection);
                System.out.println("Коллекция успешно считана");
            } else {
                System.out.println("Коллекция не была считана из-за проблем в json");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void validate(Product product) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Product> violation : violations) {
                this.isValidate = false;
                System.out.println(
                        "Ошибка при десериализации: " + violation.getPropertyPath() + "': " + violation.getMessage());
            }
        }
    }

    public List<String> read(String filename) throws FileDontExistsException {
        File file = new File(pathToCurrentDirectory + "\\" + filename);
        if (false == file.exists()) {
            throw new FileDontExistsException();
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
            return lines;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
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
