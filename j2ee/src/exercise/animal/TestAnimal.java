/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestAnimal
 * Author:   苏晨宇
 * Date:     2020/10/7 9:40
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exercise.animal;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestAnimal {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        System.out.println(cat.getName());
        cat.setName("小猫咪");
        System.out.println(cat.getName());
        cat.walk();


        Fish fish = new Fish();
        fish.eat();
        System.out.println(fish.getName());
        fish.setName("小鱼儿");
        System.out.println(fish.getName());
        fish.walk();

        Spider spider = new Spider();
        spider.eat();
    }
}
 
