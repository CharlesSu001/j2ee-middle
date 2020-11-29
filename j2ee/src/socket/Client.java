/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Client
 * Author:   苏晨宇
 * Date:     2020/10/19 20:17
 * Description: 客户端发送连接请求
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈客户端发送连接请求〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            System.out.println(s);

//            InputStream is=s.getInputStream();
//            DataInputStream dis=new DataInputStream(is);
//            OutputStream os=s.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);
//            while(true) {
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
//                dos.writeUTF(str);
//
//                String msg=dis.readUTF();
//                System.out.println("收到的消息为："+msg);
//
//            }
            new SendThread(s).start();
            new ReceiveThread(s).start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
