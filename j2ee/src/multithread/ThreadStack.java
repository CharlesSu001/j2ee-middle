/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Producer
 * Author:   苏晨宇
 * Date:     2020/10/19 15:41
 * Description: 生产者线程类 生产随机大写字符
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import collection.MyStack;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者线程类 生产随机大写字符〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class ThreadStack<T> {
    LinkedList<T> stack;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public ThreadStack() {
        stack = new LinkedList<T>();
    }

    public T pull() {
        T t = null;
        try {
            lock.lock();
            while (stack.size() <= 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            t = stack.removeLast();
        } finally {
            lock.unlock();
        }


        return t;
    }

    public void push(T t) {
        try {
            lock.lock();
            while (stack.size() >= 200) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            stack.addLast(t);
        } finally {
            lock.unlock();
        }
    }


    public T peek() {
        return stack.getLast();
    }

}
 
