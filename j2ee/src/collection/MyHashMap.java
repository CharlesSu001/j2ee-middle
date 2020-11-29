/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyHashMap
 * Author:   苏晨宇
 * Date:     2020/10/14 18:34
 * Description: 自定义HashMap
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义HashMap〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class MyHashMap implements IHashMap {
    LinkedList<Entry>[] list;

    public MyHashMap() {
        list = new LinkedList[2000];
    }

    public static int getHashCode(String str) {
        if (str.length() == 0) return 0;
        char[] cs = str.toCharArray();
        int hascode = 0;
        for (char c : cs) {
            hascode += c;
        }
        hascode *= 23;
        if (hascode < 0) hascode = Math.abs(hascode);
        if (hascode > 1999) hascode %= 2000;
        return hascode;
    }

    private static String createString(int len) {
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            Random r = new Random();
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    cs[i] = (char) (r.nextInt(26) + 97);
                    break;
                case 1:
                    cs[i] = (char) (r.nextInt(26) + 65);
                    break;
                case 2:
                    cs[i] = (char) (r.nextInt(10) + 48);
                    break;


            }


        }
        String str = new String(cs);
        return str;
    }


    @Override
    public void put(String key, Object object) {
        if (list[getHashCode(key)] == null) {
            Entry entry = new Entry(key, object);
            list[getHashCode(key)] = new LinkedList();
            list[getHashCode(key)].add(entry);
        } else {
            Entry entry = new Entry(key, object);
            list[getHashCode(key)].add(entry);
        }

    }

    @Override
    public Object get(String key) {
        if (list[getHashCode(key)] == null) return null;
        else {
            LinkedList<Entry> linkedList = new LinkedList<>();
            for (Entry e : list[getHashCode(key)]) {
                if (e.key.equals(key)) linkedList.add(e);
            }
            return linkedList;
        }
    }

    public static void main(String[] args) {
        MyHashMap test = new MyHashMap();
        Random r = new Random();
        String[] strings = new String[100];
        int[] hascode = new int[100];
        for (int i = 0; i < 100; i++) {
            int len = r.nextInt(9) + 2;
            strings[i] = createString(len);
            hascode[i] = getHashCode(strings[i]);
            System.out.format("value:%s hascode:%d%n", strings[i], hascode[i]);
            if (i % 10 == 9) System.out.println("");
        }
        ArrayList<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            heroes.add(new Hero("hero-" + (r.nextInt(9000) + 1000)));
        }
        for (Hero h : heroes) {
            test.put(h.getName(), h);
        }
        long t1 = System.currentTimeMillis();
        int i = 0;
        for (Hero h : heroes) {
            if (h.getName().equals("hero-5555")) break;
            i++;
        }
        long t2 = System.currentTimeMillis();
        if (i == 100000) System.out.println("未找到");
        else System.out.println((t2 - t1) + "ms");
        long t3 = System.currentTimeMillis();

        test.get("hero-5555");
        long t4 = System.currentTimeMillis();
        System.out.println((t4 - t3) + "ms");
    }
}
 
