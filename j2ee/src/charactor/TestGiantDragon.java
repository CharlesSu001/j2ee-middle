/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestGiantDragon
 * Author:   苏晨宇
 * Date:     2020/10/6 16:26
 * Description: 测试方法 每次都是一个对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package charactor;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试方法 每次都是一个对象〉
 *
 * @author 苏晨宇
 * @create 2020/10/6
 * @since 1.0.0
 */
public class TestGiantDragon {
    public static void main(String[] args) {
        //通过getInstance获取对象
        GiantDragon g1 = GiantDragon.getInstance();
        GiantDragon g2 = GiantDragon.getInstance();
        GiantDragon g3 = GiantDragon.getInstance();
        System.out.println(g1 == g2);
        System.out.println(g2 == g3);
    }
}
 
