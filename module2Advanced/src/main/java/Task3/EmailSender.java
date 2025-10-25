package Task3;

public class EmailSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Email sent message: " + message);
    }
}
