/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestString
 * Author:   苏晨宇
 * Date:     2020/10/7 18:51
 * Description: 字符串练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符串练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestString {
    private static String RandomString(int len) {
        short[] s = new short[len];
        char[] c = new char[len];
        for (int i = 0; i < len; i++) {
            Random r = new Random();
            int range = r.nextInt(1);
            switch (range) {
                case 1:
                    s[i] = (short) (r.nextInt(26) + 97);
                    c[i] = (char) s[i];
                    break;
                case 0:
                    s[i] = (short) (r.nextInt(26) + 65);
                    c[i] = (char) s[i];
                    break;
                case 2:
                    s[i] = (short) (r.nextInt(10) + 48);
                    c[i] = (char) s[i];
                    break;

            }

        }
        String str = new String(c);
        //System.out.println(str);
        return str;

    }

    private static void SortArray(String[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - i - 1; j++) {
                char x = s[j].charAt(0);
                char y = s[j + 1].charAt(0);
                if (Character.isUpperCase(x)) Character.toLowerCase(x);
                if (Character.isUpperCase(y)) Character.toLowerCase(y);
                if (x > y) {
                    String temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }

    private void StringArray() {
        String[] str = new String[8];
        for (int i = 0; i < 8; i++) {
            str[i] = RandomString(5);
            System.out.print(str[i] + " ");
        }
        System.out.println("");
        SortArray(str);
        for (int i = 0; i < 8; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println("");
    }

    private void decodeKey() {
        String password = RandomString(3);
        System.out.println("密码是：" + password);
        char[] guessPassword = new char[3];
        outloop:
        for (int i = 'A'; i <= 'Z'; i++) {
            for (int j = 'A'; j <= 'Z'; j++) {
                for (int k = 'A'; k <= 'Z'; k++) {
                    guessPassword[0] = (char) i;
                    guessPassword[1] = (char) j;
                    guessPassword[2] = (char) k;
                    String str = new String(guessPassword);
                    if (str.equals(password)) {
                        System.out.println("密码被破了：" + password);
                        break outloop;
                    }

                }
            }
        }

    }


    public static void main(String[] args) {
        TestString test = new TestString();
        //RandomString();
        test.StringArray();
        test.decodeKey();

    }
}
 
