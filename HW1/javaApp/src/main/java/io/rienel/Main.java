package io.rienel;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> {
            for(int i = 0; i < 1000; i ++) {
                System.out.printf("Thread[%d] i = %d\n", Thread.currentThread().getId(), i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        myThread.start();
        for(int i = 0; i < 1000; i ++) {
            System.out.printf("Thread[%d] i = %d\n", Thread.currentThread().getId(), i);
            Thread.sleep(1000);
        }
    }
}