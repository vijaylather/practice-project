package org.example.java.multithreading;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String args[]){
        SharedResource sharedResourceObj = new SharedResource(3);
        Thread producer = new Thread(() -> {
            for(int i=1;i<=6;++i){
                try {
                    sharedResourceObj.addItemToQueue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i=1;i<=6;++i){
                try {
                    sharedResourceObj.consumeItemFromQueue();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.start();
    }

}
