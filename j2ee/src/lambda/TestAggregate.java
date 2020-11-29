/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestAggregate
 * Author:   苏晨宇
 * Date:     2020/10/15 17:08
 * Description: 测试聚合操作
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lambda;

import charactor.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试聚合操作〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class TestAggregate {
    public static void traditionalMethod(ArrayList<Hero> list) {
        list.sort((h1, h2) -> (int) (h2.hp - h1.hp));
        System.out.println(list.get(2));


    }

    public static void aggregateMethod(ArrayList<Hero> heroes) {
        Hero thirdHero =
                (Hero) heroes
                        .stream()
                        .skip(2)
                        .max((h1, h2) -> (int) (h1.hp - h2.hp))
                        .get();
        System.out.println(thirdHero);
    }

    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero" + i, r.nextInt(300) + 100, r.nextInt(50) + 30));
        }
        System.out.println(heroes);
        traditionalMethod(heroes);
        aggregateMethod(heroes);
    }
}
 
