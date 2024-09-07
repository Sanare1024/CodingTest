package baekjoon.bronze5;

import java.util.Scanner;

public class Pentagon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 1;

        for(int i = 1; i <= n; i++) {
            sum += (i * 3 + 1);
        }

        System.out.println(sum % 45678);
    }
}
