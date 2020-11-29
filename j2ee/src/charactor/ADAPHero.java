/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ADAPHero
 * Author:   苏晨宇
 * Date:     2020/10/6 17:05
 * Description: 继承Hero类 实现AD AP 接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package charactor;

/**
 * 〈一句话功能简述〉<br>
 * 〈继承Hero类 实现AD AP 接口〉
 *
 * @author 苏晨宇
 * @create 2020/10/6
 * @since 1.0.0
 */
public class ADAPHero extends Hero implements AD, AP, Mortal {
    @Override
    public void physicAttack() {
        System.out.println("进行了物理攻击");
    }

    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }

    @Override
    public void attack() {
        System.out.println("进行了物理、魔法攻击");
    }

    @Override
    public void die() {
        System.out.println("AD AP 死了");
    }

    public static void main(String[] args) {
        ADAPHero h = new ADAPHero();
        h.attack();
    }
}
 
