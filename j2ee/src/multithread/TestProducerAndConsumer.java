/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestProducerAndConsumer
 * Author:   苏晨宇
 * Date:     2020/10/19 16:14
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        ThreadStack<Character> stack = new ThreadStack<>();
        new Producer(stack, "Producer1").start();
        new Producer(stack, "Producer2").start();
        new Consumer(stack, "Consumer1").start();
        new Consumer(stack, "Consumer2").start();
        new Consumer(stack, "Consumer3").start();
    }
}
 
