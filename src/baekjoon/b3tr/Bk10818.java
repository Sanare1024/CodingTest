package baekjoon.b3tr;

import java.util.Arrays;
import java.util.Scanner;

public class Bk10818 {//2357

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[n-1]);
    }
}//0001
