/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestMyIP
 * Author:   苏晨宇
 * Date:     2020/10/19 19:43
 * Description: 测试本网段可用ip
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试本网段可用ip〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class TestMyIP {
    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String ipRange = ip.substring(0, ip.lastIndexOf('.'));
        System.out.println("本机ip地址是" + ip);
        System.out.println("网段是:" + ipRange);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        AtomicInteger number = new AtomicInteger();

        for (int i = 0; i < 255; i++) {
            String testIP = ipRange + "." + (i + 1);
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    boolean reachable = isReachable(testIP);
                    if (reachable)
                        ips.add(testIP);
                    synchronized (number) {
                        System.out.println("已经完成了：" + number.incrementAndGet() + "个ip测试");
                    }
                }
            });
        }


        threadPool.shutdown();

        if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
            System.out.println("有如下IP地址");
            for (String theip : ips) {
                System.out.println(theip);
            }
            System.out.println("一共有:" + ips.size() + " 个地址");
        }
    }

    private static boolean isReachable(String ip) {
        try {
            boolean reachable = false;
            Process p = Runtime.getRuntime().exec("ping " + ip);
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                if (line.length() != 0) sb.append(line + "\r\n");

            }
            reachable = sb.toString().contains("TTL");
            br.close();
            return reachable;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
 
