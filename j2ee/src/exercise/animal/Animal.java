/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Animal
 * Author:   苏晨宇
 * Date:     2020/10/7 9:12
 * Description: 所有动物的抽象父类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exercise.animal;

/**
 * 〈一句话功能简述〉<br>
 * 〈所有动物的抽象父类〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public abstract class Animal {
    protected int legs;

    protected Animal(int l) {
        legs = l;
    }

    public abstract void eat();

    public void walk() {
        System.out.println("动物用" + legs + "条腿走路");
    }
}
 
