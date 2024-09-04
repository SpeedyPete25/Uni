public class Light {

    // Constants for brightness levels
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    // Private fields
    private int light_brightness;
    private boolean light_switch;
    private String light_color;

    // Default constructor
    public Light() {
        this.light_brightness = LOW;
        this.light_switch = false;
        this.light_color = "red";
    }

    // Accessor and Mutator methods
    public int getLightBrightness() {
        return light_brightness;
    }

    public void setLightBrightness(int light_brightness) {
        this.light_brightness = light_brightness;
    }

    public boolean isLightSwitch() {
        return light_switch;
    }

    public void setLightSwitch(boolean light_switch) {
        this.light_switch = light_switch;
    }

    public String getLightColor() {
        return light_color;
    }

    public void setLightColor(String light_color) {
        this.light_color = light_color;
    }

    // toString method to return the light's description
    @Override
    public String toString() {
        if (light_switch) {
            return "Light brightness: " + light_brightness + ", Color: " + light_color;
        } else {
            return "Color: " + light_color + ", Light is off";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // TestLight program to create and test Light objects
        Light light1 = new Light();
        light1.setLightBrightness(HIGH);
        light1.setLightColor("orange");
        light1.setLightSwitch(true);

        Light light2 = new Light();
        light2.setLightBrightness(MEDIUM);
        light2.setLightColor("green");
        light2.setLightSwitch(false);

        System.out.println(light1);
        System.out.println(light2);
    }
}
