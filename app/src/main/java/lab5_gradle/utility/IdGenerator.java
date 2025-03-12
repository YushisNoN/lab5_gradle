package lab5_gradle.utility;

import java.util.TreeSet;

import lab5_gradle.product.Product;

public class IdGenerator {
    private static Long productID = (long) 0;

    private static void setProductID(Long id) {
        productID = id;
    }

    public static void updateCounter(TreeSet<Product> productSet) {
        if (productSet.isEmpty()) {
            setProductID((long) 0);
            return;
        }
        for (Product product : productSet) {
            if (product.getId() >= productID) {
                setProductID(product.getId());
            }
        }
    }

    public static Long getProductID() {
        productID++;
        return productID;
    }

}
