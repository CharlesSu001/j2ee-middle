/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestBufferedStream
 * Author:   苏晨宇
 * Date:     2020/10/12 19:59
 * Description: 缓存流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈缓存流〉
 *
 * @author 苏晨宇
 * @create 2020/10/12
 * @since 1.0.0
 */
public class TestBufferedStream {
    public void removeComments(File javaFile) {
        //用于移除java文件中的注释
        File copyfile=new  File(javaFile.getParentFile()+"/withoutComments.txt");
        try (FileReader fr = new FileReader(javaFile); BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(copyfile); PrintWriter pw = new PrintWriter(fw)) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String temp = line;
                temp.trim();
                if (temp.length() > 1 && temp.substring(0, 2).equals("//")) {
                    pw.println("");
                }
                else {
                    pw.println(line);
                    pw.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File f = new File("E:/project/j2ee/files/chinesechar.txt");
        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        File f2 = new File("E:/project/j2ee/files/bufferchar.txt");
        try (FileWriter fw = new FileWriter(f2); PrintWriter pw = new PrintWriter(fw)) {
            pw.println("nmddsf");
            pw.flush();
            pw.println("asdfsa草拟吗");
            pw.flush();
            pw.println("死垃圾 就你？？");
            pw.flush();
            //flush是立即写入 而不是缓存满了才写入
        } catch (IOException e) {
            e.printStackTrace();
        }
        TestBufferedStream test = new TestBufferedStream();
        File javaFile = new File("E:/project/j2ee/src/hello/HelloWorld.txt");
        test.removeComments(javaFile);
    }
}
 
