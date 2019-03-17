package com.testTask.example.impl;

import com.testTask.example.api.Consumer;
import com.testTask.example.api.Producer;
import com.testTask.example.api.RingBuffer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadService {
    private RingBuffer buffer;

    public ThreadService(RingBuffer buffer) {
        this.buffer = buffer;
    }

    public void runPeriodically(int seconds) {
        Thread producer1=new Thread(new Producer(buffer,1));
        Thread producer2=new Thread(new Producer(buffer,2));
        Thread producer3=new Thread(new Producer(buffer,3));
        Thread consumer1=new Thread(new Consumer(buffer,4));
        Thread consumer2=new Thread(new Consumer(buffer,5));
       ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

        scheduler.scheduleWithFixedDelay(producer1, 0, seconds, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(producer2, 0, seconds, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(producer3, 0, seconds, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(consumer1, 0, seconds, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(consumer2, 0, seconds, TimeUnit.SECONDS);


    }



}
