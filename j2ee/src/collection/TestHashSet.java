/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestHashSet
 * Author:   苏晨宇
 * Date:     2020/10/14 10:30
 * Description: 测试HashSet
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.HashSet;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试HashSet〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class TestHashSet {

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
        HashSet<String> stringHashSet = new HashSet<String>();
        HashSet<String> key = new HashSet<String>();
        String[] strings = new String[100];
        for (int i = 0; i < 100; i++) {
            strings[i] = createString(2);
            int j=stringHashSet.size();
            stringHashSet.add(strings[i]);
            if(j==stringHashSet.size())
                key.add(strings[i]);
            System.out.print(strings[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println("");
        }
        System.out.println("============================================================");
        int i=0;
        for(String s:key){
            System.out.print(s + " ");
            if ((i + 1) % 20 == 0) System.out.println("");
            i++;
        }


    }
}
 
