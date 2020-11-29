/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CompareRandom
 * Author:   苏晨宇
 * Date:     2020/10/14 9:16
 * Description: 比较冒泡法、选择法、二叉树排序效率
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈比较冒泡法、选择法、二叉树排序效率〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class CompareRandom {
    public static class Node {
        Node leftNode;
        Node rightNode;
        int value;

        public Node() {
            value = Integer.MAX_VALUE;
        }

        public void add(int i) {
            if (value == Integer.MAX_VALUE) value = i;
            else {
                if (i > value) {
                    if (rightNode == null) rightNode = new Node();
                    rightNode.add(i);
                } else {
                    if (leftNode == null) leftNode = new Node();
                    leftNode.add(i);
                }
            }

        }

        public void sort() {
            if (leftNode != null) leftNode.sort();
            System.out.println(this.value);
            if (rightNode != null) rightNode.sort();
        }
    }

    private static void BubbleSort(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void SelectSort(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int num = 40 * 1000;
        int[] arrays = new int[num];
        for (int i = 0; i < num; i++) {
            arrays[i] = r.nextInt(100 * 1000);
        }
        long bubbleStart = System.currentTimeMillis();
        BubbleSort(arrays);
        long bubbleEnd = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            System.out.println(arrays[i]);
        }
        System.out.format("冒泡排序共耗时%dms%n", bubbleEnd - bubbleStart);


        for (int i = 0; i < num; i++) {
            arrays[i] = r.nextInt(100 * 1000);
        }
        long selectStart = System.currentTimeMillis();
        SelectSort(arrays);
        long selectEnd = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            System.out.println(arrays[i]);
        }
        System.out.format("选择排序共耗时%dms%n", selectEnd - selectStart);


        Node tree = new Node();
        for (int i = 0; i < num; i++) {
            arrays[i] = r.nextInt(100 * 1000);
            tree.add(arrays[i]);
        }
        long BiTreeStart = System.currentTimeMillis();
        tree.sort();
        long BiTreeEnd = System.currentTimeMillis();

        System.out.format("二叉树排序共耗时%dms%n", BiTreeEnd - BiTreeStart);

    }
}
 
