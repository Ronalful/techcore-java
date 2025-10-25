package Task8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Task8 {
    public static void main(String[] args) {
        System.out.println("Task submitted...");

        CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "{ \"name\": \"Alice\", \"age\": 30 }";
                })
                .thenApply(json -> "Parsed name: Alice, age: 30")
                .thenAccept(result -> System.out.println("Result received: " + result));

        System.out.println("Main thread continues working...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
