/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestInvokeMethod
 * Author:   苏晨宇
 * Date:     2020/10/21 19:59
 * Description: 调用方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package refection;

import charactor.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈调用方法〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestInvokeMethod {
    public static void main(String[] args) {
        String path = "E:/project/j2ee/files/hero.config";
        File f = new File(path);
        try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            String str = new String(all);
            String[] lines = str.split("\r\n");
            String obj1 = lines[0];
            String name1 = lines[1];
            String obj2 = lines[2];
            String name2 = lines[3];
            //类对象
            Class pclass1 = Class.forName(obj1);
            //构造器
            Constructor c1 = pclass1.getConstructor();

            Hero h1 = (Hero) c1.newInstance();

            //类对象
            Class pclass2 = Class.forName(obj2);
            //构造器
            Constructor c2 = pclass2.getConstructor();
            Hero h2 = (Hero) c2.newInstance();

            Field f1 = h1.getClass().getField("name");
            f1.set(h1, name1);

            Field f2 = h2.getClass().getField("name");
            f2.set(h2, name2);


            Method m = h1.getClass().getMethod("attackHero", Hero.class);
            m.invoke(h1, h2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
