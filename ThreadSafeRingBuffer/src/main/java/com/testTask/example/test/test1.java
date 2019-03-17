package com.testTask.example.test;

import com.testTask.example.api.Consumer;
import com.testTask.example.api.Producer;
import com.testTask.example.api.RingBuffer;
import com.testTask.example.impl.ThreadSafeRingBuffer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer buffer=new ThreadSafeRingBuffer(10);
        Thread producer1=new Thread(new Producer(buffer,1));
        Thread producer2=new Thread(new Producer(buffer,2));
        Thread producer3=new Thread(new Producer(buffer,3));
        Thread consumer1=new Thread(new Consumer(buffer,4));
        Thread consumer2=new Thread(new Consumer(buffer,5));
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);


        scheduler.scheduleWithFixedDelay(producer1, 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(producer2, 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(producer3, 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(consumer1, 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(consumer2, 0, 3, TimeUnit.SECONDS);
        while (true){
            Thread.sleep(1000);
        }
    }
}
