import threads.MyThread;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Создаю потоки...");

        //создаём задачу с результатом типа Integer
        int taskNumber = 5;
        Callable<Integer>[] myCallable = new MyThread[taskNumber];
        for (int i = 0; i < taskNumber; i++) {
            myCallable[i] = new MyThread();
        }

        int threadNumber = 3;
        //создаём пул потоков фиксированного размера
        final ExecutorService threadPool = Executors.newFixedThreadPool(threadNumber);


        for (int i = 0; i < taskNumber; i++) {
            System.out.printf("\nЗадача %d\n", i);
            //отправляем задачу на выполнение в пул потоков
            final Future<Integer> task = threadPool.submit(myCallable[i]);
            //получаем результат
            final Integer resultOfTask = task.get();
            System.out.println("Количество сообщений = " + resultOfTask);
        }

        System.out.println("\nПолучение результата от одной из задач");
        int result = threadPool.invokeAny(Arrays.stream(myCallable).toList());
        Thread.sleep(15000);
        System.out.println("res=" + result);

        //завершаем работу потоков
        threadPool.shutdown();

    }
}
