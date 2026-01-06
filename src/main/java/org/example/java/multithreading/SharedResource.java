package org.example.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> q;
    private int maxQueueSize;

    SharedResource(int queueSize){
        q = new LinkedList<>();
        maxQueueSize = queueSize;
    }

    public synchronized void addItemToQueue(int item) throws InterruptedException {
        while(q.size()==maxQueueSize) {
            System.out.println("Queue is full");
            System.out.println("Producer waiting");
            wait();
        }
        System.out.println("Producer working");
        q.offer(item);
        notifyAll();;
    }

    public synchronized void consumeItemFromQueue() throws InterruptedException {
        while(q.isEmpty()){
            System.out.println("Queue is empty");
            System.out.println("Consumer waiting");
            wait();
        }
        System.out.println("Consumer working");
        q.remove();
        notifyAll();
    }

}
