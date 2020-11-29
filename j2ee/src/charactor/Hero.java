package charactor; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Hero
 * Author:   苏晨宇
 * Date:     2020/10/4 10:17
 * Description: 英雄联盟英雄类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈英雄联盟英雄类〉
 *
 * @author 苏晨宇
 * @create 2020/10/4
 * @since 1.0.0
 */
public class Hero implements Comparable<Hero> {
    public int id;
    //
    public String name;//实例属性，对象属性，非静态属性
    public float hp;
    public int damage;
    static String copyright;//静态属性，类属性
    private static AtomicInteger hpSafe=new AtomicInteger();
    static {
        copyright = "版权由Riot Games公司所有";
    }
    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public Hero(int id,String name, float hp, int damage) {
        this.id=id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    //
//    public static void main(String[] args) {
//        Hero garen = new Hero();
//        garen.name = "盖伦";
//        Hero.copyright = "Riot Games";
//        System.out.println(garen.name);
//        System.out.println(garen.copyright);
//
//        Hero teemo = new Hero();
//        teemo.name = "提莫";
//        System.out.println(teemo.name);
//        System.out.println(teemo.copyright);
//
//        garen.copyright = "Blizzard";
//        System.out.println(garen.copyright);
//        System.out.println(teemo.copyright);
//    }
//    public String name="some hero";
    //饿汉式，静态属性 立即加载无论是否getInstance都会创建对象
//    //1.构造方法私有化
//    private Hero(){
//    }
//    //2.静态属性，指向一个实例
//    private static Hero instance=new Hero();
//    //静态方法，返回2的实例
//    public static Hero getInsance(){
//        return instance;
//    }
//    public static void main(String[] args) {
//        ADHero ad = new ADHero();
//        Hero h = ad;
//        AD adi = (AD) h;
//        APHero ap = (APHero) adi;
//    }

    //    public void kill(Mortal m) {
//        m.die();
//    }
//
//    public static void main(String[] args) {
//        Hero garen = new Hero();
//        garen.name = "盖伦";
//        ADHero ad = new ADHero();
//        APHero ap = new APHero();
//        ADAPHero adap = new ADAPHero();
//        garen.kill(ad);
//        garen.kill(ap);
//        garen.kill(adap);
//
//    }
    public String toString() {
        return "name:" + name + " hp:" + hp + " damage:" + damage;
    }

    public String getName() {
        return this.name;
    }


//    public void finalize() {
//        System.out.println("垃圾正在被回收");
//    }
//
//    public boolean equals(Object o) {
//        if (o instanceof Hero) {
//            Hero h = (Hero) o;
//            return this.hp == h.hp;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Hero h = new Hero();
//        h.name = "盖伦";
//        System.out.println(h.toString());
//        System.out.println(h);
//        Hero h1 = new Hero();
//        h1.hp = 400;
//        Hero h2 = new Hero();
//        h2.hp = 300;
//        System.out.println(h1.equals(h2));
//        System.out.println(h1 == h2);
//        System.out.println(h1.hashCode());
//    }

    @Override
    public int compareTo(Hero o) {
        return (int) (this.hp - o.hp);
    }

    public int compare(Hero h) {
        return (int) (this.hp - h.hp);
    }

    public void attackHero(Hero h) {
//        try {
//            //为了表示攻击需要时间，每次攻击暂停1000毫秒
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead())
            System.out.println(h.name + "死了！");
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

    public void aDuGenOut(int num) {
        //1秒一发

        System.out.format("波动拳第%d发%n", num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void aDuGenAccu() {

//蓄力5s
        System.out.println("开始为时5秒的充能");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hurt() {

        while (hpSafe.get()<= 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hpSafe.decrementAndGet();
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        if(hp==10)this.notify();

    }

    public  void recover() {

        if (hpSafe.get() >= 1000) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hpSafe.incrementAndGet();
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        if(hp==1)this.notify();
    }

}

 
