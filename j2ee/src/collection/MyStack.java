/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestLinkedList
 * Author:   苏晨宇
 * Date:     2020/10/13 20:24
 * Description: 用链表实现stack
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈用链表实现stack〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class MyStack implements Stack {
    LinkedList<Hero> heroes;
    Lock lock = new ReentrantLock();

    public MyStack() {
        heroes = new LinkedList<>();
    }


    @Override
    public void push(Hero h) {
        try {
            lock.lock();
            heroes.addLast(h);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public Hero pull() {
        try {
            lock.lock();
            return heroes.removeLast();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Hero peek() {
        return heroes.getLast();
    }

    public String toString() {
        return heroes.toString();
    }


    public static void main(String[] args) {
        MyStack test = new MyStack();
        Hero h1 = new Hero("garen");
        Hero h2 = new Hero("teemo");
        test.push(h1);
        test.push(h2);
        System.out.println(test);
        test.peek();
        System.out.println(test.peek());
        test.pull();
        System.out.println(test);
    }
}
 
