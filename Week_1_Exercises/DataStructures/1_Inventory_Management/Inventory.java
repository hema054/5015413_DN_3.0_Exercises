package CTS_Weekly_Exercies.Week1_DSA;
import java.util.HashMap;
import java.util.Map;


// Define the Inventory class
public class Inventory {
    public Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add a product to the inventory
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update a product in the inventory
    public void updateProduct(int productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    // Delete a product from the inventory
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    // Get a product from the inventory
    public Product getProduct(int productId) {
        return products.get(productId);
    }
}
