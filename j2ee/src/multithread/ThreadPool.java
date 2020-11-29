/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadPool
 * Author:   苏晨宇
 * Date:     2020/10/19 16:41
 * Description: 线程池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程池〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class ThreadPool {
    //线程池大小
    int threadPoolSize;
    //任务容器
    LinkedList<Runnable> tasks=new LinkedList<>();

    //试图消费任务的线程
    public ThreadPool(){
        threadPoolSize=10;
        //启动10个消费者线程
        synchronized (tasks){
            for(int i=0;i<threadPoolSize;i++){
                new TaskConsumerThread("任务消费者线程 "+i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            //唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }


    class TaskConsumerThread extends Thread{
        public TaskConsumerThread(String name){
            super(name);
        }

        Runnable task;
        public void run(){
            System.out.println("启动： "+this.getName());
            while(true){
                synchronized (tasks){
                    while(tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task=tasks.removeLast();
                    //继续添加线程
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+" 获得任务，并执行");
                task.run();
            }
        }
    }

}
 
