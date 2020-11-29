/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeadLock
 * Author:   苏晨宇
 * Date:     2020/10/19 10:38
 * Description: 死锁演示
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import charactor.Hero;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈死锁演示〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class DeadLock {
    public static void main(String[] args) {
        final Hero h1 = new Hero();
        h1.name = "劫";
        final Hero h2 = new Hero();
        h2.name = "亚索";
        final Hero h3 = new Hero();
        h3.name = "永恩";
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                boolean locked = false;
                System.out.println("劫要亚索来救");
                try {
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if (locked) {
                        System.out.println("劫占用5s");
                        Thread.sleep(5000);
                    } else System.out.println("放弃占有");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        System.out.println("亚索哥哥爱来不来");
                        lock.unlock();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                boolean locked = false;
                System.out.println("亚索要永恩来救");
                try {
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if (locked) {
                        System.out.println("亚索占用5s");
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        System.out.println("永恩哥哥爱来不来");
                        lock.unlock();
                    }
                }


            }
        };
        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                boolean locked = false;
                System.out.println("永恩要劫来救");
                try {
                    if (locked) {
                        System.out.println("永恩占用5s");
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        System.out.println("劫哥哥你爱来不来");
                        lock.unlock();
                    }
                }


            }
        };
        t3.start();
    }
}
 
