
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.png");

        // Image will be loaded from the remote server and displayed
        image1.display();
        System.out.println();

        // Image will not be loaded again, it will be displayed directly
        image1.display();
        System.out.println();

        // Image will be loaded from the remote server and displayed
        image2.display();
        System.out.println();

        // Image will not be loaded again, it will be displayed directly
        image2.display();
    }
}
