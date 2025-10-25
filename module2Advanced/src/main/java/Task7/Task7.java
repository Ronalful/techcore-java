package Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task7 {
    public static void main(String[] args) throws InterruptedException {
        List<Downloader> downloaders = new ArrayList<>(List.of(
                new Downloader(),
                new Downloader(),
                new Downloader(),
                new Downloader(),
                new Downloader()
        ));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            for (Downloader downloader : downloaders) {
                executor.submit(downloader);
            }
        } finally {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);
        }
    }
}
