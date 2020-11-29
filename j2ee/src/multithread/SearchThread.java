/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SearchThread
 * Author:   苏晨宇
 * Date:     2020/10/15 19:34
 * Description: 多线程搜索文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import java.io.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈多线程搜索文件〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class SearchThread implements Runnable {
    public File file;
    public String search;

    public SearchThread(File file, String search) {
        this.file = file;
        this.search = search;
    }

    @Override
    public void run() {
        String all = readFileContent();
        if (all.contains(search) && file.getAbsolutePath().contains(".java")) {
            System.out.format("找到字符串%s在文件%s%n", search, file.getAbsolutePath());
        }

    }

    private String readFileContent() {
        try (FileInputStream fis = new FileInputStream(file); InputStreamReader isr = new InputStreamReader(fis)) {
            char[] all = new char[(int) file.length()];
            isr.read(all);
            return new String(all);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
 
