/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestSerializableStream
 * Author:   苏晨宇
 * Date:     2020/10/13 9:18
 * Description: 对象流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import charactor.Hero;
import charactor.SerializableHero;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈对象流〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class TestSerializableStream {
    public static void main(String[] args) {
//        SerializableHero h = new SerializableHero();
//        h.name = "garen";
//        h.hp = 616;
//
//        File f = new File("E:/project/j2ee/files/garen.lol");
//
//        try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);
//             FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)) {
//            oos.writeObject(h);
//            SerializableHero h2 = (SerializableHero) ois.readObject();
//            System.out.println(h2.name);
//            System.out.println(h2.hp);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        SerializableHero[] h = new SerializableHero[10];
        File f = new File("E:/project/j2ee/files/heros.lol");
        try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)) {
            for (int i = 0; i < 10; i++) {
                h[i] = new SerializableHero(i);
                oos.writeObject(h[i]);
            }
            for (int i = 0; i < 10; i++) {
                SerializableHero h2 = (SerializableHero) ois.readObject();
                System.out.println("hero:" + h2.num);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
 
