public class BuilderPatternTest {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .build();

        // Displaying the configurations
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
