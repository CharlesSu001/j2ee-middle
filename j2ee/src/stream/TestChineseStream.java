/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestChineseStream
 * Author:   苏晨宇
 * Date:     2020/10/12 19:02
 * Description: 中文字符流
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 〈一句话功能简述〉<br>
 * 〈中文字符流〉
 *
 * @author 苏晨宇
 * @create 2020/10/12
 * @since 1.0.0
 */
public class TestChineseStream {
    public static void removeBOM(char[] cs){
        if(cs!=null) {
            int i = cs[0] & 0xff;
            System.out.format("%c字符16进制为%s%n",cs[0],Integer.toHexString(i));
        }
        String str=new String(cs);
        String substr=str.substring(1,str.length()-1);
        cs=substr.toCharArray();
    }
    public static void main(String[] args) {
//        byte[] all = {(byte)0xE5,(byte)0xB1,(byte)0x8c};
//        try {
//            String str = new String(all, "UTF-8");
//            System.out.println(str);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        File f = new File("E:/project/j2ee/files/chinesechar.txt");
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"))) {
            char[] cs = new char[(int) f.length()];
            isr.read(cs);
            removeBOM(cs);
            String result = new String(cs);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
 
