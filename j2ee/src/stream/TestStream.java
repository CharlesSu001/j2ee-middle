/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestStream
 * Author:   苏晨宇
 * Date:     2020/10/12 10:05
 * Description: 文件输入输出流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import com.sun.deploy.security.SelectableSecurityManager;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件输入输出流〉
 *
 * @author 苏晨宇
 * @create 2020/10/12
 * @since 1.0.0
 */
public class TestStream {

    //        try {
////            File f = new File("E:/project/j2ee/files/222.txt");
////            FileInputStream fis = new FileInputStream(f);//输入流，数据从硬盘到java虚拟内存中来
////           // FileOutputStream fos = new FileOutputStream(f);//输出流 从jvm到硬盘
////            byte[] all = new byte[(int) f.length()];
////            fis.read(all);
////            for (byte b : all) {
////                System.out.println(b);
////            }
////            fis.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        try{
////            File f1=new File("E:/project/j2ee/files/111.txt");
////            byte[] data={111,68};
////            FileOutputStream fos=new FileOutputStream(f1);
////            fos.write(data);
////            fos.close();
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//
//        try {
//            File f = new File("E:/xyz/abc/def/lol2.txt");
//            if (!f.exists()) f.getParentFile().mkdirs();
//            FileOutputStream fos = new FileOutputStream(f);
//            byte[] data = {26, 75, 32};
//            fos.write(data);
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    private static void splitDoc(String srcFileName, String desFileName) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File srcFile = new File(srcFileName);
        File desFile = new File(desFileName);
        try {
            //读取文件内容到jvm中
            byte[] data = new byte[(int) srcFile.length()];
            fis = new FileInputStream(srcFile);
            fis.read(data);
            //拆分成num个文件
            int num = (int) Math.floor(srcFile.length() / (1024 * 100)) + 1;
            for (int i = 0; i < num; i++) {
                fos = new FileOutputStream(desFile.getAbsoluteFile() + "\\files-" + String.valueOf(i));
                if (i < num - 1) {
                    fos.write(data, i * 1024 * 100, 1024 * 100);
                    System.out.format("输出子文件%s,其大小是%d字节%n", desFile.getAbsoluteFile() + "-" + String.valueOf(i), 1024 * 100);
                } else {
                    fos.write(data, i * 1024 * 100, (int) srcFile.length() - i * 1024 * 100);
                    System.out.format("输出子文件%s,其大小是%d字节%n", desFile.getAbsoluteFile() + "-" + String.valueOf(i), (int) srcFile.length() - i * 1024 * 100);
                }
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private static void mergeDoc(String desFileName, String directory) throws IOException {
        File f = new File(directory);
        File[] list = f.listFiles();
        int num = 0;
        for (File l : list) {
            if (l.getAbsolutePath().contains("files-")) num++;
        }
        File desFile = new File(desFileName);
        for (int i = 0; i < num; i++) {
            String srcfileName = directory + "\\files-" + String.valueOf(i);
            File srcFile = new File(srcfileName);
            try (FileInputStream fis = new FileInputStream(srcFile); FileOutputStream fos = new FileOutputStream(desFile)) {
                byte[] data = new byte[(int) srcFile.length()];
                fis.read(data);
                fos.write(data);
                fos.flush();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        String src = "E:/project/j2ee/files/Baacloud.exe";
        String des = "E:/project/j2ee/files/";
        String mergeResult = "E:/project/j2ee/files/mergeresult";
        splitDoc(src, des);
        mergeDoc(mergeResult, des);
    }

}
 
