
public class CommandPatternTest {
    public static void main(String[] args) {
        // Create a Light object
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create an invoker object
        RemoteControl remote = new RemoteControl();

        // Test turning the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println();

        // Test turning the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
