package baekjoon.b2tr;

import java.util.Arrays;
import java.util.Scanner;

public class Bk2750 { //2318

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }
} //2320
