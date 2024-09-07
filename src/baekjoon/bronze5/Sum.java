package baekjoon.bronze5;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String a = sc.next(); //100자리수는 int나 long으로 안되니까  string으로 받

        int sum = 0;

        for (int i = 0; i < n; i++){
            sum += a.charAt(i) - 48;
        }

        System.out.println(sum);
    }
}
