/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyStringBuffer
 * Author:   苏晨宇
 * Date:     2020/10/8 9:55
 * Description: 实现IS
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

import java.util.Random;

import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;

/**
 * 〈一句话功能简述〉<br>
 * 〈实现IStringBuffer接口〉
 *
 * @author 苏晨宇
 * @create 2020/10/8
 * @since 1.0.0
 */
public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;

    //无参构造方法
    public MyStringBuffer() {
        value = new char[capacity];
    }

    //带参构造方法
    public MyStringBuffer(String str) {
        this();
        if (str == null) return;
        if (str.length() > capacity) {
            capacity = value.length * 2;
            value = new char[capacity];
        }
        if (str.length() <= capacity) {
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }
        length = str.length();

    }

    @Override
    public void append(String str) throws NullPointerException, IndexIsNagetiveException, IndexIsOutofRangeException{
        insert(length, str);

    }

    @Override
    public void append(char c) throws NullPointerException, IndexIsNagetiveException, IndexIsOutofRangeException{
        append(String.valueOf(c));

    }

    @Override
    public void insert(int pos, char b) throws NullPointerException, IndexIsNagetiveException, IndexIsOutofRangeException{
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) throws NullPointerException, IndexIsNagetiveException, IndexIsOutofRangeException{
        //边界条件判断
        if (pos > length) throw new IndexIsOutofRangeException();
        if (b == null) throw new NullPointerException();
        if (pos < 0) throw new IndexIsNagetiveException();
        //扩容
        while (capacity < length + b.length()) {
            capacity = (int) (length + b.length() * 1.5);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
        char[] cs = b.toCharArray();
        //把后半段数据往后移动
        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        //插入数据
        System.arraycopy(cs, 0, value, pos, cs.length);
        length = length + cs.length;


    }

    @Override
    public void delete(int start) throws IndexIsNagetiveException, IndexIsOutofRangeException{
        if (start > length) throw new IndexIsOutofRangeException();
        if (start < 0) throw new IndexIsNagetiveException();
        char[] newValue = new char[start];
        System.arraycopy(value, 0, newValue, 0, start);
        value = newValue;
        length = start;

    }

    @Override
    public void delete(int start, int end) throws IndexIsNagetiveException, IndexIsOutofRangeException{
        if (start < 0) throw new IndexIsNagetiveException();
        if (start >=end) throw new IndexIsOutofRangeException();

        if (end > length) throw new IndexIsOutofRangeException();
        char[] value2 = new char[length - end];
        System.arraycopy(value, end, value2, 0, length - end);
        char[] value1 = new char[start];
        System.arraycopy(value, 0, value1, 0, start);

        char[] newValue = new char[length - (end - start)];
        System.arraycopy(value1, 0, newValue, 0, value1.length);
        System.arraycopy(value2, 0, newValue, value1.length, value2.length);
        value = newValue;
        length = length - (end - start);
    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {
            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }


    }

    @Override
    public int length() {

        return length;
    }

    @Override
    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
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

    public static void main(String[] args) {
        try {
            MyStringBuffer test = new MyStringBuffer("盖伦大宝剑");
            System.out.println(test.length());
            test.append("提莫小蘑菇");
            test.append('s');
            System.out.println(test);
            test.insert(1, "nm");
            test.insert(1, 'b');
            System.out.println(test);
            test.reverse();
            System.out.println(test);
            test.delete(6);
            System.out.println(test);
            test.delete(1, 3);
            System.out.println(test);

            String[] strList = new String[100000];
            MyStringBuffer b1 = new MyStringBuffer();
            StringBuffer b2 = new StringBuffer();
            for (int i = 0; i < 100000; i++) {
                strList[i] = createString(10);
            }
            long startTime1 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                b1.append(strList[i]);
            }
            long endTime1 = System.currentTimeMillis();
            System.out.format("我的方法耗时%dms", endTime1 - startTime1);

            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                b2.append(strList[i]);
            }
            long endTime2 = System.currentTimeMillis();
            System.out.format("系统的方法耗时%dms", endTime2 - startTime2);
        } catch (IndexIsOutofRangeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IndexIsNagetiveException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
 
