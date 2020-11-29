/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ReceiveThread
 * Author:   苏晨宇
 * Date:     2020/10/19 20:52
 * Description: 接受线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br>
 * 〈接受线程〉
 *
 * @author 苏晨宇
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
                System.out.println("收到的消息为" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
