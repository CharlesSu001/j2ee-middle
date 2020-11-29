/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestSocket
 * Author:   苏晨宇
 * Date:     2020/10/19 19:17
 * Description: 获取本机IP地址
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取本机IP地址〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class TestSocket {
    public static  void main(String[] args) throws UnknownHostException, IOException {
        InetAddress host=InetAddress.getLocalHost();
        String ip=host.getHostAddress();
        System.out.println(ip);

        Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }
}
 
