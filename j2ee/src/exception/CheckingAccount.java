/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CheckingAccount
 * Author:   苏晨宇
 * Date:     2020/10/11 9:29
 * Description: 继承Accont类 具备透支额度
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

/**
 * 〈一句话功能简述〉<br>
 * 〈继承Accont类 具备透支额度〉
 *
 * @author 苏晨宇
 * @create 2020/10/11
 * @since 1.0.0
 */
public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double protect) {
        super(balance);
        overdraftProtection = protect;
    }

    @Override
    public void withdraw(double amt) throws OverdraftException {
        if (balance - amt >= 0) {
            balance -= amt;
            System.out.println("账户余额为" + balance);
        } else if (amt - balance < overdraftProtection) {
            System.out.format("已超支%f元%n", amt - balance);
        } else {
            throw new OverdraftException("已超透支额度", amt - balance - overdraftProtection);
        }
    }
}
 
