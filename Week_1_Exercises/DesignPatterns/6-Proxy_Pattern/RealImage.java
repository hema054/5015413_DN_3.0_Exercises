
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        // Simulate a delay for loading the image
        try {
            Thread.sleep(2000); // Simulate loading time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fileName + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
