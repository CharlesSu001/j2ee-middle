/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestReflection
 * Author:   苏晨宇
 * Date:     2020/10/21 17:17
 * Description: 测试反射机制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package refection;

import charactor.Hero;

import java.lang.reflect.Constructor;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试反射机制〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestReflection {
    public static void main(String[] args) {
//        String className = "charactor.Hero";
//        try {
//            Class pClass1 = Class.forName(className);
//            Class pClass2 = Hero.class;
//            Class pClass3 = new Hero().getClass();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        try {
            //使用反射的方式创建对象
            String className = "charactor.Hero";
            //类对象
            Class pClass=Class.forName(className);
            //构造器
            Constructor c= pClass.getConstructor();
            //通过构造器实例化
            Hero h2= (Hero) c.newInstance();
            h2.name="gareen";
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
 
