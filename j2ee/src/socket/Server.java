/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Server
 * Author:   苏晨宇
 * Date:     2020/10/19 20:14
 * Description: 服务端打开端口监听
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈服务端打开端口监听〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("监听在端口8888");
            Socket s = ss.accept();
            System.out.println("有连接过来" + s);

//            InputStream is=s.getInputStream();
//            DataInputStream dis=new DataInputStream(is);
//            OutputStream os=s.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);
//            while(true) {
//
//                String msg = dis.readUTF();
//                System.out.println("收到的消息为："+msg);
//                Scanner sc=new Scanner(System.in);
//                String str=sc.next();
//                dos.writeUTF(str);
//            }
            new SendThread(s).start();
            new ReceiveThread(s).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
