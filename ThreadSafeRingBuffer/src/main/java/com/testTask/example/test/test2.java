package com.testTask.example.test;

import com.testTask.example.api.RingBuffer;
import com.testTask.example.impl.ThreadSafeRingBuffer;

public class test2 {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer buffer=new ThreadSafeRingBuffer(10);

        while (true){
            Thread.sleep(1000);
        }
    }

}
