package lab5_gradle;

import lab5_gradle.utility.FileReader;
import lab5_gradle.utility.Kernel;

public class App {
    public static void main(String[] args) throws Exception {
        Kernel kernel = new Kernel();
        kernel.setCommands();
        if (args.length == 1) {
            FileReader.setFileName(args[0]);
        }
        kernel.runProgram();
    }
}

/*
 * 
 * try {
 * Product testProduct = new Product.ProductBuilder()
 * .setName("Aboba")
 * .setPrice(-90)
 * .setCoordinates(new Coordinates())
 * .setOwner(new Person.PersonBuilder()
 * .setName("Ivan")
 * .setHeight(100.02f)
 * .buildPerson())
 * .buildProduct();
 * System.out.println(testProduct.toString());
 * } catch (Exception e) {
 * System.out.println(e.getMessage());
 * }
 */