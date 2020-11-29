/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestException
 * Author:   苏晨宇
 * Date:     2020/10/9 14:50
 * Description: 异常测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package exception;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈异常测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/9
 * @since 1.0.0
 */
public class TestException {
    //    public static void main(String[] args) {
//        File f = new File("G:/WeGame/wegame.exe");
//        try {
//            System.out.println("试图打开文件");
//            new FileInputStream(f);
//            System.out.println("文件打开成功");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println("试图转换日期");
//            Date d = sdf.parse("2016/06/03");
//            System.out.println("日期转换成功");
//        } catch (FileNotFoundException | ParseException e) {
//            if (e instanceof FileNotFoundException) System.out.println("文件不存在");
//            if (e instanceof ParseException) System.out.println("日期解析错误");
//            e.printStackTrace();
//        }
//        finally{
//            System.out.println("无论是否出现异常，finally的代码都会执行");
//        }
//    }
    public static void main(String[] args) {
        try {
            methods1();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static void methods1() throws Throwable {
        methods2();
    }

    public static int method() {
        try {
            System.out.println(1);
            return 1;
        } catch (Exception e) {
            System.out.println(2);
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println(3);
            //return 3;
        }
    }

    private static void methods2() throws Throwable {
        File f = new File("d:/LOL.exe");
        System.out.println("试图打开");
        new FileInputStream(f);
        System.out.println("成功打开");
        method();
        System.out.println("运行时异常RunTimeError 不需要进行try" +
                "catch 处理 也能编译通过不强制捕捉");
        System.out.println("错误Error是系统级别的错误也不强制要求捕捉");
        System.out.println("非运行时异常也是可查异常 必须进行捕捉 否则编译不通过");
    }
}
 
