package com.testTask.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements Runnable {

    private RingBuffer buffer;
    private int number;
    final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public Consumer(RingBuffer buffer, int number) {
        this.buffer = buffer;
        this.number = number;
    }

    public void run() {
        try {
            if (!buffer.isEmpty()) {
                int position = buffer.get();
                logger.info("поток " + number + " прочитал данные из ячейки " + position);
            } else {
                logger.info("поток " + number + " пытается прочесть из пустой ячейки");
            }
        } catch (RingBufferExeption ringBufferExeption) {
            ringBufferExeption.printStackTrace();
        }
    }
}
