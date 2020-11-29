/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Producer
 * Author:   苏晨宇
 * Date:     2020/10/19 15:55
 * Description: 生产者类 生产随机大写字符压入堆栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import collection.MyStack;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者类 生产随机大写字符压入堆栈〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class Producer extends Thread {
    private ThreadStack<Character> stack;

    public Producer(ThreadStack<Character> stack, String name) {
        super(name);
        this.stack = stack;
    }

    static public Character createChar() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 65);
    }

    @Override
    public void run() {
        while (true) {
            char c = createChar();
            System.out.println(this.getName() + " 压入：" + c);
            stack.push(c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
