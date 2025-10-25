package Task7;

import java.util.concurrent.TimeUnit;

public class Downloader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Начало выполнения потока");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Завершение выполнения потока");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
