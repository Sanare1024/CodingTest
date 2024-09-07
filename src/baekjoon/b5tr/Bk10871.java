package baekjoon.b5tr;

import java.util.Scanner;

public class Bk10871 {//1503

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];

        //둘째줄 수열받기
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //x와 비교해서 작은수 출력
        for (int i= 0; i < n; i++){
            if(a[i] < x) {
                System.out.print(a[i] + " ");
            }
        }
    }
} //1508
