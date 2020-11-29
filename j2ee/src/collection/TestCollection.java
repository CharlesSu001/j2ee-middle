/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestCollection
 * Author:   苏晨宇
 * Date:     2020/10/13 16:28
 * Description: 集合类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈集合类测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class TestCollection {
    public static boolean search(String name, Hero h) {
        return h.name.equals(name);
    }

    public static void main(String[] args) {
        ArrayList heros = new ArrayList();
//        heros.add(new Hero("garen"));
//        System.out.println(heros.size());
//
//        heros.add(new Hero("teemo"));
//        System.out.println(heros.size());
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);
        Hero shero = new Hero("special hero");
        heros.add(3, shero);
        System.out.println(heros);

        // 判断一个对象是否在容器中
        // 判断标准： 是否是同一个对象，而不是name是否相同
        System.out.print("虽然一个新的对象名字也叫 hero1，但是contains的返回是:");
        System.out.println(heros.contains(new Hero("hero1")));
        System.out.print("而对specialHero的判断，contains的返回是:");
        System.out.println(heros.contains(shero));
        System.out.println(heros.get(5));
        System.out.println("specialHero所处的位置:" + heros.indexOf(shero));
        System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + heros.indexOf(new Hero("hero 1")));
        heros.remove(2);
        heros.remove(shero);
        System.out.println(heros);
        heros.set(1, new Hero("garen"));
        System.out.println(heros);
        heros.clear();
        System.out.println(heros);
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i));
        }
        boolean flag = false;
        String name = "teemo";
        for (int i = 0; i < 10; i++) {
            flag = search(name, (Hero) heros.get(i));
            if (flag) {
                System.out.format("找到了name是%s的对象%n", name);
                break;
            }

        }
        System.out.format("未找到name是%s的对象%n", name);

        System.out.println(heros);

    }

}
 
