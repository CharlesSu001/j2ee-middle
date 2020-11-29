/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ReverseKeyAndValue
 * Author:   苏晨宇
 * Date:     2020/10/14 16:55
 * Description: 反转Key和Value
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈反转Key和Value〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class ReverseKeyAndValue {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adc", "物理英雄");
        hashMap.put("apc", "魔法英雄");
        hashMap.put("t", "坦克");
        System.out.println(hashMap);

        Object[] keyArray = hashMap.keySet().toArray();
        Object[] valueArray = hashMap.values().toArray();
        hashMap.clear();
        for (int i = 0; i < keyArray.length; i++) {
            hashMap.put(valueArray[i].toString(), keyArray[i].toString());
        }
        System.out.println(hashMap);
    }
}
 
