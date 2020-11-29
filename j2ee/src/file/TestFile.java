/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestFile
 * Author:   苏晨宇
 * Date:     2020/10/11 9:58
 * Description: I/O流练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package file;

import java.io.File;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈I/O流练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/11
 * @since 1.0.0
 */
public class TestFile {

    static long maxLen = 0;
    static String maxFileName = "";
    static long minLen = Integer.MAX_VALUE;
    static String minFileName = "";

    //递归遍历子文件夹
    private static void traverse(File f) {
        if (f.exists()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File ff : files) {
                    if (ff.isDirectory()) traverse(ff);
                    else {
                        if (ff.length() > maxLen) {
                            maxLen = ff.length();
                            maxFileName = ff.getAbsolutePath();
                        }
                        if (ff.length() < minLen) {
                            minLen = ff.length();
                            minFileName = ff.getAbsolutePath();
                        }
                    }
                }
            }

        } else {
            System.out.println("文件不存在");
        }
    }

    public static void main(String[] args) {
        //绝对路径
//        File f1 = new File("G:/WeGame");
//        System.out.println("f1的绝对路径" + f1.getAbsolutePath());
//        //工作目录下的相对路径
//        File f2 = new File("LOL.exe");
//        System.out.println("f2的绝对路径" + f2.getAbsolutePath());
//        //f1作为子目录 创建对象文件
//        File f3=new File(f1,"LOL.exe");
//        System.out.println("f3的绝对路径" + f3.getAbsolutePath());
//        File f = new File("E:/project/j2ee/files/TestFile.txt");
//        System.out.println("当前文件是" + f);
//
//        System.out.println("判断文件是否存在 " + f.exists());
//
//        System.out.println("判断是否是文件夹 " + f.isDirectory());
//
//        System.out.println("判断是否是文件 " + f.isFile());
//
//        System.out.println("获取文件长度 " + f.length());
//
//        long time = f.lastModified();
//        Date d = new Date(time);
//        System.out.println("最后修改时间 " + d);
//        f.setLastModified(0);
//        //文件重命名
//        File f2 = new File("E:/project/j2ee/files/testfile.txt");
//        f.renameTo(f2);
//        System.out.println(f.getName());
//
//        File f1 = new File("E:/project/j2ee/files");
//        String[] list = f1.list();
//        for (String l : list) {
//            System.out.println(l);
//        }
//        File[] fs = f1.listFiles();
//        for (File s : fs) {
//            System.out.println(s.getName());
//        }
//        System.out.println(f.getParent());
//        System.out.println(f.getParentFile().getName());
//        f.mkdir();
//        f.mkdirs();
//        f.deleteOnExit();
//        File f = new File("C:/Windows");
//        long maxLen = 0;
//        String maxFileName = "";
//        long minLen = Integer.MAX_VALUE;
//        String minFileName = "";
//        File[] fs = f.listFiles();
//        for (File ff : fs) {
//            if (ff.length() > maxLen) {
//                maxLen = ff.length();
//                maxFileName = ff.getAbsolutePath();
//            }
//            if (ff.length() < minLen && ff.length() != 0) {
//                minLen = ff.length();
//                minFileName = ff.getAbsolutePath();
//            }
//        }
//        System.out.format("最大文件是%s,其大小是%d字节%n", maxFileName, maxLen);
//        System.out.format("最小文件是%s,其大小是%d字节%n", minFileName, minLen);
        File f = new File("C:/Windows");
        traverse(f);
        System.out.format("最大文件是%s,其大小是%d字节%n", maxFileName, maxLen);
        System.out.format("最小文件是%s,其大小是%d字节%n", minFileName, minLen);
    }
}
 
