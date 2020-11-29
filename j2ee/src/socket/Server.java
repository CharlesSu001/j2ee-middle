/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: Server
 * Author:   �ճ���
 * Date:     2020/10/19 20:14
 * Description: ����˴򿪶˿ڼ���
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ��һ�仰���ܼ�����<br>
 * ������˴򿪶˿ڼ�����
 *
 * @author �ճ���
 * @create 2020/10/19
 * @since 1.0.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("�����ڶ˿�8888");
            Socket s = ss.accept();
            System.out.println("�����ӹ���" + s);

//            InputStream is=s.getInputStream();
//            DataInputStream dis=new DataInputStream(is);
//            OutputStream os=s.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);
//            while(true) {
//
//                String msg = dis.readUTF();
//                System.out.println("�յ�����ϢΪ��"+msg);
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
 
