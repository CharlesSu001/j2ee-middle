package hello;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class HelloJava {
    public static void main(String[] args) {
//        int p = 12000;
//        float r = 0.05f;
//        int sum = 0;
//        for (int i = 1; i < 100; i++) {
//            int year = i;
//            float interestRate = 1;
//            for (int j = 0; j < year; j++) {
//                interestRate *= 1 + r;
//            }
//            int interest = (int) (p * interestRate);
//            sum += interest;
//            if (sum > 1000 * 1000) {
//                System.out.println(year);
//                break;
//            }
//        }
//        float point = 0.618f;
//        float len = 1f;
//        float split = 0;
//        float bestSplit = 0;
//        int bestI = 0;
//        int bestJ = 0;
//        for (int i = 1; i < 21; i++) {
//            for (int j = i + 1; j < 21; j++) {
//                if (i % 2 == 0 && j % 2 == 0) continue;
//
//                split = (float) i / j;
//                float dis = Math.abs(split - point);
//                if (dis < len) {
//                    len = dis;
//                    bestSplit = split;
//                    bestI = i;
//                    bestJ = j;
//                }
//
//
//            }
//        }
//        System.out.println(bestI + "/" + bestJ + "=" + bestSplit);
//        int u = 0;
//        int v = 0;
//        int w = 0;
//        int x = 0;
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                int a = 8 - i;
//                int b = j - 6;
//                if (a < 0 || b < 0) continue;
//                if (i + j != 14 || a + b != 10) continue;
//                u = i;
//                v = 8 - u;
//                w = j;
//                x = j - 6;
//
//            }
//
//        }
//        System.out.println("a: " + u + "b: " + v + "c: " + w + "d: " + x);
//
//        int[] values = new int[]{18, 62, 68, 82, 65, 9};
//        int max = 0;
//        for (int each : values) {
//            if (each > max) max = each;
//        }
//        System.out.println(max);
//        Random r = new Random();
//        int lenA = r.nextInt(6) + 5;//产生5-10的随机数
//        int lenB = r.nextInt(6) + 5;
//        int[] a = new int[lenA];
//        int[] b = new int[lenB];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = r.nextInt(100);
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("");
//
//        for (int i = 0; i < b.length; i++) {
//            b[i] = r.nextInt(100);
//            System.out.print(b[i] + " ");
//        }
//        System.out.println("");
//        int lenC=a.length+b.length;
//        int[] c=new int[lenC];
//        System.arraycopy(a,0,c,0,lenA);
//        System.arraycopy(b,0,c,lenA,lenB);
//        for (int i = 0; i < c.length; i++) {
//            System.out.print(c[i] + " ");
//        }
//        System.out.println("");


        Random r = new Random();
        int[][] a = new int[5][8];
        int[] b = new int[a.length * a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = r.nextInt(100);
                System.out.print(a[i][j] + " ");
            }
            System.arraycopy(a[i], 0, b, i * a[0].length, a[0].length);
            System.out.println("");
        }
        int[] c = Arrays.copyOfRange(b, 0, b.length);
        Arrays.sort(c);

        for (int i = 0; i < a.length; i++) {

            a[i] = Arrays.copyOfRange(c, i * a[0].length, (i + 1) * a[0].length);

        }


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}