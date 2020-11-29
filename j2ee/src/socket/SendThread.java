/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SendThread
 * Author:   苏晨宇
 * Date:     2020/10/19 20:46
 * Description: 发送线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈发送线程〉
 *
 * @author 苏晨宇
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
 
