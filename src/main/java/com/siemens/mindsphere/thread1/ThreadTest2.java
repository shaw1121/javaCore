package com.siemens.mindsphere.thread1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by da5wwf
 * on 8/22/2018 20:07.
 */


//描述资源。
class Resource
{
    private String name;
    private String sex;
    //定义标记
    private Boolean flag = false;

    private final Lock lock = new ReentrantLock();

    //通过锁对象获取监视器对象
    private Condition con = lock.newCondition();

    //赋值功能
    public void set(String name, String sex){
        lock.lock();
        try{
            if(flag)
                try {con.await();}catch (InterruptedException e){}
            this.name = name;
            this.sex = sex;

            flag = true;
            con.signal();
        }finally {
            lock.unlock();
        }

    }

    //get the value
    public void out(){
        lock.lock();
        try{
            if(!flag)
                try {con.await();}catch (InterruptedException e){}
            System.out.println(name + "....." + sex);

            flag = false;
            con.signal();
        }finally {
            lock.unlock();
        }

    }
}
//赋值线程任务
class Input implements Runnable
{
    private Resource r;

    //	private Object obj = new Object();
    Input(Resource r)//任务一初始化就必须有要处理的资源。
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while(true)
        {
            if(x==0)
            {
                r.set("jack", "man");
            }
            else
            {
                r.set("rose", "woman");
            }

            x = (x+1)%2;//实现切换。
        }
    }
}
//获取值线程任务
class Output implements Runnable
{
    private Resource r ;
    //	private Object obj = new Object();
    Output(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.out();
        }
    }
}

class ThreadTest2
{
    public static void main(String[] args)
    {
        Resource r = new Resource();
        Input in = new Input(r);
        Output out = new Output(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();

    }
}
