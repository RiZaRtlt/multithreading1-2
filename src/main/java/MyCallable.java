import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable {

    @Override
    public Object call() throws Exception {
        int i = 0;
        int max = 10;

        double j = Math.random() * ++max;

        try {
            while (i < j) {
                Thread.sleep(2000);
                System.out.println("Сообщение " + (i+1) + " из потока " + Thread.currentThread().getName());
                i++;
            }
        } catch (InterruptedException err) {

        } finally {
            //System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return i;
    }
}
