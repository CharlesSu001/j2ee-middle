/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestNumber
 * Author:   苏晨宇
 * Date:     2020/10/7 9:53
 * Description: 封装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package digit;

/**
 * 〈一句话功能简述〉<br>
 * 〈封装类〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestNumber {
    public static void main(String[] args) {
        int i = 5;
        Integer it = new Integer(i);
        int i2 = it.intValue();
        System.out.println(it instanceof Number);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
 
