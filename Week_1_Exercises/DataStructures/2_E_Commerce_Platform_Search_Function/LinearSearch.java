package CTS_Weekly_Exercies.Week1_DSA.E_commerce;

public class LinearSearch {
    public static int search(Product[] products, int targetProductId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetProductId) {
                return i;
            }
        }
        return -1;
    }
}