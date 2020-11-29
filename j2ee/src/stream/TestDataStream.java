/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestDataStream
 * Author:   苏晨宇
 * Date:     2020/10/12 20:54
 * Description: 数据流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据流〉
 *
 * @author 苏晨宇
 * @create 2020/10/12
 * @since 1.0.0
 */
public class TestDataStream {
    private static void method1DataStream(int a, int b) {
        File numFile = new File("E:/project/j2ee/src/stream/numFile.txt");
        try (FileWriter fw = new FileWriter(numFile); PrintWriter pw = new PrintWriter(fw);
             FileReader fr = new FileReader(numFile); BufferedReader br = new BufferedReader(fr)) {
            String str = String.valueOf(a) + "@" + String.valueOf(b);
            //写入文件
            pw.println(str);
            fw.close();
            String[] nums = br.readLine().split("@");
            for (String n : nums) {
                System.out.println(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method2DataStream(int a, int b) {
        File numFile = new File("E:/project/j2ee/src/stream/numFile1.txt");
        try (FileOutputStream fos = new FileOutputStream(numFile); DataOutputStream dos = new DataOutputStream(fos);
             FileInputStream fis = new FileInputStream(numFile); DataInputStream dis = new DataInputStream(fis)) {
            dos.writeInt(a);
            dos.writeInt(b);
            int aa = dis.readInt();
            int bb = dis.readInt();
            System.out.println(aa);
            System.out.println(bb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method1DataStream(31, 25);
        method2DataStream(182, 158);
    }
}
 
