package Task6;

import java.util.ArrayList;
import java.util.List;

public class Task6 {
    public static void main(String[] args) throws InterruptedException {
        List<Downloader> downloaders = new ArrayList<>(List.of(
                new Downloader(),
                new Downloader(),
                new Downloader(),
                new Downloader(),
                new Downloader()
        ));

        long start, end;
        start = System.currentTimeMillis();
        for (Downloader downloader : downloaders) {
            downloader.run();
        }
        end = System.currentTimeMillis();
        System.out.println("Последовательное выполнение: " + (end - start) / 1000);


        List<Thread> threads = new ArrayList<>();
        start = System.currentTimeMillis();
        for (Downloader downloader : downloaders) {
            var thread = new Thread(downloader);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        end = System.currentTimeMillis();
        System.out.println("Параллельное выполнение: " + (end - start) / 1000);
    }
}
