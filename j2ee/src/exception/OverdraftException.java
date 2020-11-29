/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OverdraftException
 * Author:   苏晨宇
 * Date:     2020/10/9 17:24
 * Description: 透支异常，继承Exception
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

/**
 * 〈一句话功能简述〉<br>
 * 〈透支异常，继承Exception〉
 *
 * @author 苏晨宇
 * @create 2020/10/9
 * @since 1.0.0
 */
public class OverdraftException extends Exception {
    private double deficit;

    public OverdraftException() {

    }

    public OverdraftException(String messaage, double deficit) {
        super(messaage);
        System.out.format("已超额度%f%n", deficit);
    }

    public double getDeficit() {
        return deficit;
    }
}
 
