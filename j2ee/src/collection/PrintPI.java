/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PrintPI
 * Author:   苏晨宇
 * Date:     2020/10/14 17:12
 * Description: LinkedHashSet 有顺序的set
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.LinkedHashSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈LinkedHashSet 有顺序的set〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class PrintPI {
    public static void main(String[] args){
        LinkedHashSet<Character> linkedHashSet=new LinkedHashSet<>();
        String pi=String.valueOf(Math.PI);
        char[] cs=pi.toCharArray();
        for (char c : cs) {
            if (c != '.') linkedHashSet.add(c);
        }
        System.out.println(linkedHashSet);
    }
}
 
