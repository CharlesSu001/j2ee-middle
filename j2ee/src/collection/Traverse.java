/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Traverse
 * Author:   苏晨宇
 * Date:     2020/10/13 20:04
 * Description: 遍历List
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈遍历List〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class Traverse {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            heroes.add(new Hero("hero" + i));
        }
        System.out.println(heroes);
        Iterator<Hero> it = heroes.iterator();
        int i = 0;
        while (it.hasNext()) {
            Hero h = it.next();
            if (i % 8 == 0)
                it.remove();
            i++;
        }
        System.out.println(heroes);
    }
}
 
