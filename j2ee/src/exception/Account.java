/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Account
 * Author:   苏晨宇
 * Date:     2020/10/9 17:16
 * Description: 银行账号
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

import exception.OverdraftException;

/**
 * 〈一句话功能简述〉<br>
 * 〈银行账号〉
 *
 * @author 苏晨宇
 * @create 2020/10/9
 * @since 1.0.0
 */
public class Account {
    protected double balance;//属性 金额

    public Account() {
        this.balance = 0;
    }

    public Account(double init) {
        this.balance = init;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) throws OverdraftException {
        if (balance - amt < 0) throw new OverdraftException("透支异常 已欠费", amt - getBalance());
        else{
            this.balance-=amt;
            System.out.format("账户余额为%f%n",balance);
        }

    }

}
 
