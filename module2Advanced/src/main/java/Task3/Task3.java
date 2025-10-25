package Task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        var senders = new ArrayList<>(List.of(
                new EmailSender(),
                new SmsSender(),
                new PushSender()
        ));

        senders.forEach(sender -> sender.send("Hello World"));
    }
}
