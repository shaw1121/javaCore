package com.siemens.mindsphere.stopThread;

/**
 * Created by da5wwf
 * on 8/25/2018 09:23.
 */
public class StopThreadDemo {
    public static void main(String[] args)
    {
        Demo d = new Demo();

        Thread t1 = new Thread(d,"consumer");
        Thread t2 = new Thread(d,"producer");//给线程命名
        t1.start();
        //将t2标记为后台线程，守护线程。
//		t2.setDaemon(true);
        t2.start();

        int x = 0;
        while(true)
        {
            if(++x == 50)//条件满足。
            {
                //对t1线程对象进行中断状态的清除，强制让其恢复到运行状态。
                //t1.interrupt();
                //对t2线程对象进行中断状态的清除，强制让其恢复到运行状态。
                //t2.interrupt();

                break;//跳出循环，主线程可以结束。
            }
            System.out.println("main-------->" + x);
        }

        System.out.println("over");
    }
}

class Demo implements Runnable
{
    private boolean flag = true;

    //未使用同步
//    public void run(){
//        while (flag){
//            System.out.println(Thread.currentThread().getName() + "---->");
//        }
//    }

    //使用同步，线程在任务中处于冻结状态不能通过标记的方法判断来决定终止
    public synchronized void run()
    {
        while(flag)
        {
            try
            {
                wait();//t1  t2
            }
            catch (InterruptedException e)
            {
                System.out.println(Thread.currentThread().toString()+"....."+e.toString());
                changeFlag();
            }

            System.out.println(Thread.currentThread().getName()+"----->");
        }
    }
    //对标记的修改方法。
    public void changeFlag()
    {
        flag = false;
    }
}
