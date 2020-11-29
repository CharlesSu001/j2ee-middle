/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestConsoleStream
 * Author:   苏晨宇
 * Date:     2020/10/13 9:45
 * Description: System.in测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import java.io.*;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈System.in测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class TestConsoleStream {
    private static String firstToUpper(String s) {
        if (Character.isLowerCase(s.charAt(0))) s.replace(s.charAt(0), Character.toUpperCase(s.charAt(0)));
        return s;
    }

    private static void createClass(String name, String type, String property) {
        File template = new File("E:/project/j2ee/src/stream/ClassTemplate");
        File output = new File("E:/project/j2ee/src/stream/" + name + ".java");
        try (FileReader fr = new FileReader(template); BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(output); PrintWriter pw = new PrintWriter(fw)) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String newLine = line.replace("@class@", name);
                newLine = newLine.replace("@type@", type);
                newLine = newLine.replace("@property@", property);
                String uproperty = firstToUpper(property);
                newLine = newLine.replace("@Uproperty@", uproperty);
                pw.println(newLine);
                pw.flush();
            }
            System.out.println("文件保存在" + output);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(name);
//        System.out.println(type);
//        System.out.println(property);
    }

    public static void main(String[] args) {
//        try (InputStream is = System.in) {
//            while (true) {
//                int i = is.read();
//                System.out.println(i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scanner s=new Scanner(System.in);
//        int a=s.nextInt();
//        System.out.println("第一个整数:"+a);
        Scanner s = new Scanner(System.in);
        System.out.println("请输入类的名称:");
        String name = s.nextLine();
        System.out.println("请输入属性的类型:");
        String type = s.nextLine();
        System.out.println("请输入属性的名称:");
        String property = s.nextLine();
        createClass(name, type, property);
    }
}
 
