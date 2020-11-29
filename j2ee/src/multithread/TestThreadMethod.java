/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestThreadMethod
 * Author:   苏晨宇
 * Date:     2020/10/15 19:58
 * Description: 线程方法练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import charactor.Hero;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程方法练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class TestThreadMethod {
    public static void main(String[] args) {
//        Thread t1 = new Thread() {
//            public void run() {
//                int seconds = 0;
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
//                }
//            }
//
//        };
//        t1.start();
//        final Hero gareen = new Hero();
//        gareen.name = "盖伦";
//        gareen.hp = 616;
//        gareen.damage = 50;
//
//        final Hero teemo = new Hero();
//        teemo.name = "提莫";
//        teemo.hp = 300;
//        teemo.damage = 30;
//
//        final Hero bh = new Hero();
//        bh.name = "赏金猎人";
//        bh.hp = 500;
//        bh.damage = 65;
//
//        final Hero leesin = new Hero();
//        leesin.name = "盲僧";
//        leesin.hp = 455;
//        leesin.damage = 80;
//
//        Thread t1= new Thread(){
//            public void run(){
//                while(!teemo.isDead()){
//                    gareen.attackHero(teemo);
//                }
//            }
//        };
//
//        t1.start();
//
//        //代码执行到这里，一直是main线程在运行
//        try {
//            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
//            t1.join();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        Thread t2= new Thread(){
//            public void run(){
//                while(!leesin.isDead()){
//                    bh.attackHero(leesin);
//                }
//            }
//        };
//        //会观察到盖伦把提莫杀掉后，才运行t2线程
//        t2.start();
//        final Hero gareen = new Hero();
//        gareen.name = "盖伦";
//        gareen.hp = 6160;
//        gareen.damage = 1;
//
//        final Hero teemo = new Hero();
//        teemo.name = "提莫";
//        teemo.hp = 3000;
//        teemo.damage = 1;
//
//        final Hero bh = new Hero();
//        bh.name = "赏金猎人";
//        bh.hp = 5000;
//        bh.damage = 1;
//
//        final Hero leesin = new Hero();
//        leesin.name = "盲僧";
//        leesin.hp = 4505;
//        leesin.damage = 1;
//
//        Thread t1= new Thread(){
//            public void run(){
//
//                while(!teemo.isDead()){
//                    gareen.attackHero(teemo);
//                }
//            }
//        };
//
//        Thread t2= new Thread(){
//            public void run(){
//                while(!leesin.isDead()){
//                    Thread.yield();
//                    bh.attackHero(leesin);
//                }
//            }
//        };
//
//        t1.setPriority(5);
//        t2.setPriority(5);
//        t1.setDaemon(true);
//
//        t1.start();
//        t2.start();
        final Hero hero = new Hero();
        Thread t1 = new Thread() {
            public void run() {
                int count = 1;
                while (true) {
//                  try{
//                      Thread.sleep(1000);
//                  }catch(InterruptedException e){
//                      e.printStackTrace();
//                  }
                    hero.aDuGenOut(count);
                    count++;
                    if (count == 4) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count = 1;
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        hero.aDuGenAccu();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    try {
//                        Thread.sleep(5000);
//                        hero.aDuGenAccu();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }

            }
        };
        t1.start();
        t2.start();

    }
}
 
