package Task9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Task9 {
    public static void main(String[] args) {
        System.out.println("Task submitted...");

        CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    throw new RuntimeException("Something went wrong during async task!");
                })
                .thenApply(json -> "Parsed result: " + json)
                .exceptionally(ex -> {
                    System.out.println("Error occurred: " + ex.getMessage());
                    return "{ \"name\": \"Default\", \"age\": 0 }";
                })
                .thenAccept(result -> System.out.println("Final result: " + result));

        System.out.println("Main thread continues working...");

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
