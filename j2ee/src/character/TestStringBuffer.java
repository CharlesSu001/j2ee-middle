/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestStringBuffer
 * Author:   苏晨宇
 * Date:     2020/10/8 9:37
 * Description: 测试字符缓存
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试字符缓存〉
 *
 * @author 苏晨宇
 * @create 2020/10/8
 * @since 1.0.0
 */
public class TestStringBuffer {

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
        String[] str = new String[100000];
        String stringResult = "";
        StringBuffer bufferResult = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            str[i] = createString(10);
        }
        long startTime1 = System.currentTimeMillis();
        for (String s : str) {
            stringResult += s;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.format("耗时%d毫秒%n", endTime1 - startTime1);

        long startTime2=System.currentTimeMillis();
        for (String s : str) {
           bufferResult.append(s);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.format("%s耗时%d毫秒%n", bufferResult,endTime2 - startTime2);

    }
}
 
