/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Fish
 * Author:   苏晨宇
 * Date:     2020/10/7 9:33
 * Description: 继承Animal类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exercise.animal;

/**
 * 〈一句话功能简述〉<br>
 * 〈继承Animal类〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class Fish extends Animal implements Pet {
    private String name;

    public Fish() {
        super(0);
        System.out.println("小鱼的无参构造");
    }

    @Override
    public void eat() {
        System.out.println("小鱼吃了");
    }

    @Override
    public void walk() {
        System.out.println("小鱼没有腿，走不了路了");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
 
