package Task3;

public class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sms sent message: " + message);
    }
}
