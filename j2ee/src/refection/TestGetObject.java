/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestGetObject
 * Author:   苏晨宇
 * Date:     2020/10/21 19:16
 * Description: 通过配置文件获取对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package refection;

import charactor.Hero;
import collection.Item;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈通过配置文件获取对象〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestGetObject {
    public static Hero getHero() {
        Hero hero = null;
        String path = "E:/project/j2ee/files/hero.config";
        File f = new File(path);
        try (FileInputStream fis = new FileInputStream(f); InputStreamReader isr = new InputStreamReader(fis)) {
            char[] cs = new char[(int) f.length()];
            isr.read(cs);
            //使用反射方式获取对象
            String objName = new String(cs);
            //类对象
            Class pclass = Class.forName(objName);
            //构造器
            Constructor c = pclass.getConstructor();

            //通过构造器实例化
            hero = (Hero)c.newInstance();
            return hero;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Hero h=new Hero();
        h.name="teemo";
        System.out.println(h.name);

        try{
            Field f1=h.getClass().getDeclaredField("name");
            f1.set(h,"亚索");
            System.out.println(h.name);
        }catch (Exception e){
            e.printStackTrace();
        }
        Item item=new Item();
        try{
            Method m=item.getClass().getMethod("setName",String.class);
            m.invoke(item,"巫妖之祸");
            Method m2=item.getClass().getMethod("getName");
            System.out.println(m2.invoke(item));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
 
