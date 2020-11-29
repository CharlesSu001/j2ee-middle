/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestInteract
 * Author:   苏晨宇
 * Date:     2020/10/19 11:06
 * Description: 线程交互
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import charactor.Hero;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程交互〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class TestInteract {
    public static void main(String[] args) {
        final Hero garen = new Hero("garen", 1000);
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
       t1.start();

        Thread t10 = new Thread() {
            public void run() {
                while (true) {
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t10.start();

        Thread t11 = new Thread() {
            public void run() {
                while (true) {
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t11.start();

        Thread t12 = new Thread() {
            public void run() {
                while (true) {
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t12.start();

        Thread t13 = new Thread() {
            public void run() {
                while (true) {
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t13.start();

        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    garen.recover();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            public void run() {
                while (true) {
                    garen.recover();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t3.start();


    }
}
 
