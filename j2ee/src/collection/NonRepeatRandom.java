/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: NonRepeatRandom
 * Author:   苏晨宇
 * Date:     2020/10/14 16:20
 * Description: 不重复的随机数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈不重复的随机数〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class NonRepeatRandom {
    public static void main(String[] args) {
        Random r = new Random();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> key = new HashSet<>();
        while (true) {
            int j = set.size();
            int item = r.nextInt(10000);
            set.add(item);
            if (j < set.size()) key.add(item);
            if (key.size() == 50) break;
        }
        System.out.println(key);

    }
}
 
