/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: ReceiveThread
 * Author:   �ճ���
 * Date:     2020/10/19 20:52
 * Description: �����߳�
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ��һ�仰���ܼ�����<br>
 * �������̡߳�
 *
 * @author �ճ���
 * @create 2020/10/19
 * @since 1.0.0
 */
public class ReceiveThread extends Thread{
    private Socket s;

    public ReceiveThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println("�յ�����ϢΪ" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
