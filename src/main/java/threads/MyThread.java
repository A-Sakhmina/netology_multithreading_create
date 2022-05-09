package threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(String.format("Я %s. Всем привет!", Thread.currentThread().getName()));
                sleep(2500);
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
    }
}
