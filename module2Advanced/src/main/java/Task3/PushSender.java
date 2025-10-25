package Task3;

public class PushSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Push sent message: " + message);
    }
}
