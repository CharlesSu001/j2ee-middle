/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestCharacter
 * Author:   苏晨宇
 * Date:     2020/10/7 18:42
 * Description: 字符处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符处理〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestCharacter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if (Character.isUpperCase(c) || Character.isDigit(c)) System.out.print(c);
        }
    }
}
 
