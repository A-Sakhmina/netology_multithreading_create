import threads.MyThread;

public class Main {
    public static void main(String[] args) {
        //группа потоков
        ThreadGroup group = new ThreadGroup("group");

        System.out.println("Создаю потоки...");

        MyThread task = new MyThread();

        int threadNumber = 3;
        final Thread[] threads = new Thread[threadNumber];
        //добавление потоков в группу
        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(group, task, String.format("поток %d", i));
        }

        // запуск потоков
        for (Thread thread : threads) {
            thread.start();
        }

        //завершаем потоки
        group.interrupt();

    }
}
