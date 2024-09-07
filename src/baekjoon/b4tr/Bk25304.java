package baekjoon.b4tr;

import java.util.Scanner;

public class Bk25304 { //2103

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총금액 X 물품 종류 N
        int x = sc.nextInt();
        int n = sc.nextInt();
        int sum =0;

        //이후 N개의 줄에 가격 a와 개수 b가 공백으로 주어짐
        //sum도 여기서 해버림
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sum += a * b;
        }

        if (sum == x) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
} //2112 틀림 2115 중간에 디버그로 오타 찾음
