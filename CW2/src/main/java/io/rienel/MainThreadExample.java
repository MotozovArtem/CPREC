package io.rienel;

public class MainThreadExample {
    public static void main(String[] args) throws InterruptedException {
//        double sum = 0.0;
//        long start = System.currentTimeMillis();
//        for (int i = 1; i <= 1_000_000_000; i++) {
//            sum += Math.pow(i, 2.0/3.0);
//        }
//        long stop = System.currentTimeMillis();
//        System.out.println("Sum = " + sum);
//        System.out.println("TIME = " + (stop - start));


        MathTask task1 = new MathTask();
        task1.a = 1;
        task1.b = 250_000_000;
        MathTask task2 = new MathTask();
        task2.a = 250_000_001;
        task2.b = 500_000_000;
        MathTask task3 = new MathTask();
        task3.a = 500_000_001;
        task3.b = 750_000_000;
        MathTask task4 = new MathTask();
        task4.a = 750_000_001;
        task4.b = 1_000_000_000;


        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        Thread t4 = new Thread(task4);

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        double sum = task1.sum + task2.sum + task3.sum + task4.sum;
        long stop = System.currentTimeMillis();
        System.out.println("SUM=" + sum);
        System.out.println("time=" + (stop-start));
    }
}