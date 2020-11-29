/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Consumer
 * Author:   苏晨宇
 * Date:     2020/10/19 16:10
 * Description: 消费者类 从栈中弹出字符
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

/**
 * 〈一句话功能简述〉<br>
 * 〈消费者类 从栈中弹出字符〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class Consumer extends Thread {
    ThreadStack<Character> stack;

    public Consumer(ThreadStack<Character> stack, String name) {
        super(name);
        this.stack = stack;
    }

    public void run() {
        while (true) {
            char c = stack.pull();
            System.out.println(this.getName() + " 弹出：" + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
 
