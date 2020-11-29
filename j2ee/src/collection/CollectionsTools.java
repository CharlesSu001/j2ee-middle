/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CollectionsTools
 * Author:   苏晨宇
 * Date:     2020/10/14 11:12
 * Description: 集合工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈集合工具类〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class CollectionsTools {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("原始list为:" + list);
        int shuffle = 1000 * 1000;
        int count = 0;
        for (int j = 0; j < shuffle; j++) {
            Collections.shuffle(list);
            if (list.get(0) == 3 && list.get(1) == 1 && list.get(2) == 4) count++;
        }
        float fre=(float)count/shuffle;
        System.out.println(fre*100+"%");
    }
}
 
