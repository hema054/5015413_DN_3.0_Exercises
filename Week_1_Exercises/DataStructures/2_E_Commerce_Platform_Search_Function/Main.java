package CTS_Weekly_Exercies.Week1_DSA.E_commerce;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product(1, "Apple iPhone", "Electronics");
        products[1] = new Product(2, "Samsung TV", "Electronics");
        products[2] = new Product(3, "Nike Shoes", "Fashion");
        products[3] = new Product(4, "Adidas Jacket", "Fashion");
        products[4] = new Product(5, "Sony Headphones", "Electronics");

        int targetProductId = 5;
 
        /*creating object for linearSearch class, and adding 1 to returned index value to extract position 
        or we can also print the index itself*/
        int linearSearchResult = LinearSearch.search(products, targetProductId);
        if (linearSearchResult != -1) {
            System.out.println("Linear Search: Product found at index " + linearSearchResult+1);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        //For binary search it only works with sorted arrays, here as i given sorted , it executes

        int binarySearchResult = BinarySearch.search(products, targetProductId);
        if (binarySearchResult != -1) {
            System.out.println("Binary Search: Product found at index " + binarySearchResult+1);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}






