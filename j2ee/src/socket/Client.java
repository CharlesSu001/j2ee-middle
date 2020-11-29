/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: Client
 * Author:   �ճ���
 * Date:     2020/10/19 20:17
 * Description: �ͻ��˷�����������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ��һ�仰���ܼ�����<br>
 * ���ͻ��˷�����������
 *
 * @author �ճ���
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
//                System.out.println("�յ�����ϢΪ��"+msg);
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
 
