package com.gurpreet;

import java.util.concurrent.locks.ReentrantLock;

public class CounterAmongThreads implements Runnable{
    static int counter;
    static int limit =10;
    static ReentrantLock lock = new ReentrantLock(true);

    //No need to use synchronized if using locking via ReentrantLock
    synchronized void incrementCounter(){
        //lock.lock();
        try {
            if(counter<limit)
            System.out.println(Thread.currentThread().getName() + ": " + ++counter);
            Thread.yield();
        }finally {
           // lock.unlock();
        }
    }

    @Override
    public void run() {
        while(counter <limit){
            incrementCounter();
        }
    }



    public static void main(String... ar){
        CounterAmongThreads ob1 = new CounterAmongThreads();
        Thread ob2 = new Thread(ob1);
        Thread ob3 = new Thread(ob1);
        Thread ob4 = new Thread(ob1);

        ob2.start();
        ob3.start();
        ob4.start();
    }
}
