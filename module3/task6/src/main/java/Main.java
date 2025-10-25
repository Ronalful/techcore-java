public class Main {
    public static void main(String[] args) {
        String env = System.getProperty("env");
        System.out.println("Active profile: " + env);
    }
}
