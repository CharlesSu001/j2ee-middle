/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyStringBuffer
 * Author:   苏晨宇
 * Date:     2020/10/13 17:12
 * Description: ArrayList实现StringBuffer
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈ArrayList实现StringBuffer〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class MyStringBuffer implements IStringBuffer {

    ArrayList value;

    public MyStringBuffer() {
        value = new ArrayList();
    }

    public MyStringBuffer(String s) {
        this();
        if (s == null) return;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            value.add(c);
        }
    }

    @Override
    public String toString() {
        char[] c = new char[value.size()];
        for (int i = 0; i < value.size(); i++) {
            c[i] = (char) value.get(i);
        }
        return new String(c);

    }


    @Override
    public void append(String str) {
        insert(value.size(), str);
    }

    @Override
    public void append(char c) {
        insert(value.size(), c);
    }

    @Override
    public void insert(int pos, char b) {
        value.add(pos, b);
    }

    @Override
    public void insert(int pos, String b) {
        if (pos < 0) return;
        if (b == null) return;
        if (pos > value.size()) return;
        char[] cs = b.toCharArray();
        int i = pos;
        for (char c : cs) {
            insert(i, c);
            i++;
        }
    }

    @Override
    public void delete(int start) {
        delete(start, value.size());
    }

    @Override
    public void delete(int start, int end) {
        if (start < 0) return;
        if (end > value.size()) return;
        if (end <= start) return;
        for (int i = 0; i < end - start; i++) {
            value.remove(start);
        }


    }

    @Override
    public void reverse() {
        for (int i = 0; i < value.size() / 2; i++) {
            char c1 = (char) value.get(i);
            char c2 = (char) value.get(value.size() - 1 - i);
            value.set(i, c2);
            value.set(value.size() - 1 - i, c1);

        }

    }

    @Override
    public int length() {
        return value.size();
    }

    public static void main(String[] args) {
        String str = "garen";
        MyStringBuffer test = new MyStringBuffer(str);
        System.out.println(test);
        test.append("teemo");
        System.out.println(test);
        test.delete(1, 3);
        System.out.println(test);
        test.reverse();
        System.out.println(test);
        List heros=new ArrayList();
        List<Hero> heros1=new ArrayList<Hero>();
        List<Hero> heros2=new ArrayList<>();
        List<LOL> lols=new ArrayList<>();
        CHero chero=new CHero("garen");
        Item item=new Item("巫妖之祸");
        lols.add(chero);
        lols.add(item);
        //lols.add(str);
    }
}
 
