/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestAccount
 * Author:   苏晨宇
 * Date:     2020/10/11 9:44
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author 苏晨宇
 * @create 2020/10/11
 * @since 1.0.0
 */
public class TestAccount {
    public static void main(String[] args) {
        Account a1 = new Account(10000);
        a1.deposit(10000);
        System.out.println(a1.getBalance());
        try {
            a1.withdraw(20001);
        } catch (OverdraftException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        CheckingAccount a2 = new CheckingAccount(10000, 2000);
        a2.deposit(10000);
        System.out.println(a2.getBalance());
        try {
            a2.withdraw(30000);
        } catch (OverdraftException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
 
