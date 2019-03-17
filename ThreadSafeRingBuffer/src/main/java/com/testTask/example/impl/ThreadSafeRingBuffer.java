package com.testTask.example.impl;

import com.testTask.example.api.RingBuffer;
import com.testTask.example.api.RingBufferExeption;

public class ThreadSafeRingBuffer implements RingBuffer {
    private String[] elements;
    private int head;
    private int tail;
    private int length;
    private int size;

    public ThreadSafeRingBuffer(int size) {
        elements = new String[size];
        this.size = size;
        head = size - 1;
        tail = size - 1;

    }

    public synchronized int put(String elementIn) throws RingBufferExeption {
        if (isFull()) throw new RingBufferExeption("Cant put in Full Buffer");
        head = (head + 1) % size;
        elements[head] = elementIn;
        length++;
        return head;
    }

    public synchronized int get() throws RingBufferExeption {
        if (isEmpty()) throw new RingBufferExeption("Cant read from empty Buffer");
        tail = (tail + 1) % size;
        elements[tail] = null;
        length--;
        return tail;
    }

    public int size() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }

    public String[] getElements() {
        return elements;
    }
}
