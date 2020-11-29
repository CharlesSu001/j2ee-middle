/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestCharStream
 * Author:   苏晨宇
 * Date:     2020/10/12 17:09
 * Description: 字符流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符流〉
 *
 * @author 苏晨宇
 * @create 2020/10/12
 * @since 1.0.0
 */
public class TestCharStream {
    public static void encodeFile(File encodingFile, File encodedFile) {
        if (encodingFile.exists()) {
            if (!encodedFile.exists()) encodedFile.getParentFile().mkdirs();
            try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
                char[] all = new char[(int) encodingFile.length()];
                fr.read(all);
                System.out.println("加密前的内容：");
                for (char b : all) {
                    System.out.print(b);
                }
                System.out.println("");
                StringBuffer result = new StringBuffer();
                for (char r : all) {
                    //如果是数字
                    if (r <= '9' && r >= '0') {
                        if (r != '9') r += 1;
                        else r = '0';
                    }
                    //如果是字母
                    else if ((r <= 'Z' && r >= 'A') || (r <= 'z' && r >= 'a')) {
                        if (r != 'z' && r != 'Z') r += 1;
                        else if (r == 'z') r = 'a';
                        else r = 'A';
                    }
                    result.append(r);

                }
                String str = result.toString();
                System.out.println("加密后的内容");
                System.out.println(str);
                char[] data = str.toCharArray();
                fw.write(data);
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("需要加密文件的不存在");
        }
    }


    public static void decodeFile(File decodingFile, File decodedFile) {
        if (decodingFile.exists()) {
            if (!decodedFile.exists()) decodedFile.getParentFile().mkdirs();
            try (FileReader fr = new FileReader(decodingFile); FileWriter fw = new FileWriter(decodedFile)) {
                char[] all = new char[(int) decodingFile.length()];
                fr.read(all);
                System.out.println("源文件的内容：");
                for (char b : all) {
                    System.out.print(b);
                }
                System.out.println("");
                StringBuffer result = new StringBuffer();
                for (char r : all) {
                    //如果是数字
                    if (r <= '9' && r >= '0') {
                        if (r != '0') r -= 1;
                        else r = '9';
                    }
                    //如果是字母
                    else if ((r <= 'Z' && r >= 'A') || (r <= 'z' && r >= 'a')) {
                        if (r != 'z' && r != 'Z') r -= 1;
                        else if (r == 'a') r = 'z';
                        else r = 'Z';
                    }
                    result.append(r);

                }
                String str = result.toString();
                char[] data = str.toCharArray();
                System.out.println("解密后的内容:");
                System.out.println(str);
                fw.write(data);
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("源文件不存在");
        }
    }


    public static void main(String[] args) {
        String encodingPath = "E:/project/j2ee/files/password.txt";
        String encodedPath = "E:/project/j2ee/files/key.txt";
        String decodePath = "E:/project/j2ee/files/decode.txt";
        File encoding = new File(encodingPath);
        File encoded = new File(encodedPath);
        File decode = new File(decodePath);
        encodeFile(encoding, encoded);
        decodeFile(encoded, decode);
    }

}
 
