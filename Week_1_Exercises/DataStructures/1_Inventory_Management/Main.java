package CTS_Weekly_Exercies.Week1_DSA;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product(1, "Apple iPhone", 10, 999.99);
        Product product2 = new Product(2, "Samsung TV", 5, 1299.99);
        Product product3 = new Product(3, "Nike Shoes", 20, 79.99);

        inventory.addProduct(product1);//adding products created into inventory
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // Print and showing after each operation
        System.out.println("Initial Inventory:");
        printInventory(inventory);

        
        inventory.updateProduct(2, 10, 1499.99);// Update a product
        
        System.out.println("Updated Inventory:");
        printInventory(inventory);
       
        inventory.deleteProduct(1); // Delete a product

        System.out.println("Final Inventory:");
        printInventory(inventory);
    }

    private static void printInventory(Inventory inventory) {
        for (Product product : inventory.products.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }
}