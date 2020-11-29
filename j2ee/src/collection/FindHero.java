/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindHero
 * Author:   苏晨宇
 * Date:     2020/10/14 9:56
 * Description: 查找Hero对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈查找Hero对象〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class FindHero {
    public static void main(String[] args) {
        List<Hero> heroList = new ArrayList<>();
        int num = 300 * 1000 * 1000;
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            heroList.add(new Hero("hero-" + (r.nextInt(9000) + 1000)));
        }
        long t1 = System.currentTimeMillis();
        int flag = 0;
        for (Hero h : heroList) {
            if (h.getName().equals("hero-5555"))
                break;
            flag++;
        }
        long t2 = System.currentTimeMillis();
        if (flag != num)
            System.out.format("for each查找耗时%dms%n", t2 - t1);
        else System.out.format("查找失败%n");

        HashMap<String, Hero> heroMap = new HashMap<>();
        for (Hero h : heroList) {
            heroMap.put(h.getName(), h);
        }
        long t3 = System.currentTimeMillis();
        Hero h = heroMap.get("hero-5555");
        long t4 = System.currentTimeMillis();
        if (h != null) System.out.format("hashMap查找耗时%dms%n", t4 - t3);
        else System.out.format("查找失败%n");
    }
}
 
