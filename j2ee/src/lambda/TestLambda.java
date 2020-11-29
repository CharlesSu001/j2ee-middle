/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestLambda
 * Author:   苏晨宇
 * Date:     2020/10/15 11:00
 * Description: Lambda表达式测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lambda;

import charactor.Hero;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈Lambda表达式测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class TestLambda {
    public static int testHero(Hero h1,Hero h2){
        return h1.hp>=h2.hp?1:-1;
    }
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();

        for (int i = 0; i < 10; i++) {
            //通过随机值实例化hero的hp和damage
            heros.add(new Hero("hero " + i, r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        //直接调用sort会出现编译错误，因为Hero有各种属性
        //到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
        //Collections.sort(heros);

        //引入Comparator，指定比较的算法
//        Comparator<Hero> c = new Comparator<Hero>() {
//            @Override
//            public int compare(Hero h1, Hero h2) {
//                //按照hp进行排序
//                if (h1.hp >= h2.hp)
//                    return 1;  //正数表示h1比h2要大
//                else
//                    return -1;
//            }
//        };
//        //保留方法参数、方法体
//        Comparator c2 = (Hero h1, Hero h2) -> {
//            return h1.hp >= h2.hp ? 1 : -1;
//        };
//
//        //去掉return和{}
//        Comparator c3 = (Hero h1, Hero h2) -> h1.hp >= h2.hp ? 1 : -1;
//        //去掉参数类型
//        Comparator c4 = (h1, h2) -> h1.hp >= h2.hp ? 1 : -1;

        //Collections.sort(heros, (h1, h2) ->(int)(h1.hp-h2.hp));
        //Lambda表达式调用静态方法
        //Collections.sort(heros,(h1,h2)->TestLambda.testHero(h1,h2));
        //直接调用静态方法
        //Collections.sort(heros, TestLambda::testHero);

        //引用容器中的对象方法Lambda表达式
        //Collections.sort(heros,(h1,h2)->h1.compare(h2));
        //直接引用
        Collections.sort(heros,Hero::compare);
        System.out.println("按照血量排序后的集合：");
        System.out.println(heros);
    }
}
 
