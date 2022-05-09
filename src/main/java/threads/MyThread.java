package threads;

import java.util.concurrent.Callable;


public class MyThread implements Callable<Integer> {

    private int countMessages;

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println(String.format("Я %s. Всем привет!", Thread.currentThread().getName()));
            countMessages++;
            Thread.sleep(2500);
        } catch (
                InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
            countMessages++;
        }
        return countMessages;
    }
}
