package baekjoon.b4tr;

import java.util.Scanner;

public class Bk2845 {//2301

    public static void main(String[] args) {
        //1m2당 사람의 수 L  파티가 열렸던 곳의 넓이 P
        //각 기사에 실려있는 참가자의 수가 주어진다. 106보다 작은 양의 정수 5개
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int p = sc.nextInt();
        int people = l * p;

        for(int i = 0; i < 5; i++){
            int a = sc.nextInt();
            System.out.print(a - people + " ");
        }

    }
}//2305
