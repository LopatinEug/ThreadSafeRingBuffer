package com.testTask.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer implements Runnable {

    private RingBuffer buffer;
    private int number;
    final Logger logger = LoggerFactory.getLogger(Producer.class);

    public Producer(RingBuffer buffer, int number) {
        this.buffer = buffer;
        this.number = number;
    }

    public void run() {
        try {
            if (!buffer.isFull()) {
                int position = buffer.put("поток с номером " + number + " записал данные");
                logger.info("поток " + number + " записал данные в ячейку " + position);
            } else {
                logger.info("поток " + number + " пытается записать в заполненный буффер");
            }

        } catch (RingBufferExeption ringBufferExeption) {
            ringBufferExeption.printStackTrace();
        }
    }
}
