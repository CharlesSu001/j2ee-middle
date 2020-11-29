/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PrimeNumber
 * Author:   苏晨宇
 * Date:     2020/10/7 16:49
 * Description: 找出1000w以内所有质数个数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package digit;

/**
 * 〈一句话功能简述〉<br>
 * 〈找出1000w以内所有质数个数〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class PrimeNumber {
    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int maxNum = 1000 * 1000 * 10;
        int count = -1;
        for (int i = 1; i < maxNum; i++) {
            if (isPrime(i)) count++;
        }
        System.out.println(count);
    }
}
 
