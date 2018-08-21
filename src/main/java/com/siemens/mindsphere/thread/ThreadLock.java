package com.siemens.mindsphere.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by da5wwf
 * on 8/21/2018 22:51.
 */
public class ThreadLock {
    public static void main(String[] args){

        //1,创建资源对象。
        Resource r = new Resource();

        //2,创建线程任务。
        Consumer con = new Consumer(r);
        Producer prod = new Producer(r);

        //3. create thread
        Thread t1 = new Thread(con);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(prod);
        Thread t4 = new Thread(prod);

        //start 4 threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Resource{
    private String name;
    private int count = 1;

    //定义一个锁对象
    private final Lock lock = new ReentrantLock();

    //获取锁上的condition 对象，为了解决本方唤醒对方的问题，可以一个锁创建两个监视器对象
    private Condition produce = lock.newCondition();// monitor produce
    private Condition consume = lock.newCondition();//monitor consume

    //定义标记，面包有无
    private boolean flag = false;

    public void set(String name){
        //获取锁
        lock.lock();
        try{
            while(flag){ //为true会一直等待，直到false 跳出，面包没有才生产
                try {
                    produce.await();
                }catch(Exception e){

                }
            }

            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "...producer..." + this.name);

            flag = true; // 生产面包后，改变标记状态

            consume.signal();

        }finally {
            lock.unlock(); //一定要解锁
        }


    }

    public void out(){
        lock.lock();
        try{
            while(!flag){
                try {
                    consume.await();
                }catch (InterruptedException e){

                }
            }
            System.out.println(Thread.currentThread().getName()+"....consumer...."+this.name);

            flag = false;
            produce.signal();
        }finally {
            lock.unlock();
        }
    }
}

//2,描述生产者。
class Producer implements Runnable{

    private Resource r;
    // 生产者一初始化就要有资源，需要将资源传递到构造函数中。
    Producer(Resource r){
        this.r = r;
    }

    public void run(){
        while(true){
            r.set("bread");
        }
    }
}

//3,描述消费者。
class Consumer implements Runnable{

    private Resource r;
    // 消费者一初始化就要有资源，需要将资源传递到构造函数中。
    Consumer(Resource r){
        this.r = r;
    }

    public void run(){
        while (true){
            r.out();
        }
    }
}