import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/5.
 */
public class OpConcurrentMap {
    public static long time(Executor executor, int Occument, Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(Occument);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(Occument);
        for (int i = 0; i < Occument; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startNano = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNano;
    }

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Now thats Start");
            }
        };
        long result = 0;
        try {
            result = time(Executors.newFixedThreadPool(5), 4, run);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
