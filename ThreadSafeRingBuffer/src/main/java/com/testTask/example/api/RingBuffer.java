package com.testTask.example.api;

public interface RingBuffer {
    public int put(String s) throws RingBufferExeption;
    public int get() throws RingBufferExeption;
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public String[] getElements();
}
