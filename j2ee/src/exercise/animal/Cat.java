/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Cat
 * Author:   苏晨宇
 * Date:     2020/10/7 9:27
 * Description: 猫类 实现Pet接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exercise.animal;

/**
 * 〈一句话功能简述〉<br>
 * 〈猫类 实现Pet接口〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class Cat extends Animal implements Pet {
    String name;

    public Cat(String name) {
        super(4);
        this.name = name;

    }

    public Cat() {
        this("");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("猫吃了");
    }
}
 
