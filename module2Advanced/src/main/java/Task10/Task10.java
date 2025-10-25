package Task10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Task10 {
    public static void main(String[] args) {
        long start;
        start = System.currentTimeMillis();
        System.out.println("Dashboard loading started...");

        CompletableFuture<String> futureProfile = CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "UserProfile{name='Alice', age=30}";
                });

        CompletableFuture<String> futureOrders = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Orders[order1, order2, order3]";
        });

        CompletableFuture<String> dashboardFuture = futureProfile.thenCombine(
                futureOrders,
                (profile, orders) -> "DashboardDTO{\n  profile=" + profile + ",\n  orders=" + orders + "\n}"
        );

        dashboardFuture.thenAccept(result -> {
            System.out.println("Dashboard ready:\n" + result);
            System.out.println("Request time: " + (System.currentTimeMillis() - start) / 1000);
        });

        System.out.println("Main thread continues working...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
