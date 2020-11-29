/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: SendThread
 * Author:   �ճ���
 * Date:     2020/10/19 20:46
 * Description: �����߳�
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * ��һ�仰���ܼ�����<br> 
 * �������̡߳�
 *
 * @author �ճ���
 * @create 2020/10/19
 * @since 1.0.0
 */
public class SendThread extends Thread{
    private Socket s;
    public SendThread(Socket s){
        this.s=s;
    }
    public void run(){
        try{
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);

            while(true){
                Scanner sc=new Scanner(System.in);
                String str=sc.next();
                dos.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
