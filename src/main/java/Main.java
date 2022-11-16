import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Object> myCallable = new MyCallable();

        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Callable<Object>> futures = new ArrayList<>();

        for (int i =0; i<4; i++) {
            futures.add(myCallable);
        }

        Object rezult = pool.invokeAny(futures);

        System.out.println("Было выведено " + rezult.toString() + " сообщений. Потоки уничтожены!");

        pool.shutdown();
    }
}
