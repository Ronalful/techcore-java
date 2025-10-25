package Task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> emails = new ArrayList<>();

        emails.add("alice@gmail.com");
        emails.add("bob@gmail.com");
        emails.add("alice@gmail.com");
        emails.add("charlie@yahoo.com");
        emails.add("dave@yahoo.com");
        emails.add("eve@hotmail.com");
        emails.add("frank@hotmail.com");
        emails.add("grace@gmail.com");
        emails.add("heidi@outlook.com");
        emails.add("ivan@outlook.com");
        emails.add("bob@gmail.com");
        emails.add("eve@hotmail.com");

        System.out.println(emails);

        var emailsSet = new HashSet<>(emails);
        System.out.println(emailsSet);

        var emailsMap = new HashMap<String, Integer>();
        for (String email : emailsSet) {
            var domen = email.split("@")[1];
            emailsMap.put(domen, emailsMap.getOrDefault(domen, 0) + 1);
        }

        for (var entry : emailsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
