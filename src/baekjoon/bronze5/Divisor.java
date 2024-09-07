package baekjoon.bronze5;

import java.util.Scanner;

public class Divisor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N 받어
        int K = sc.nextInt(); //K 받어

        int divisor = 0; //약수 개수

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisor++;  //약수가 나오면 divisor을 1개씩 쌓아서 순서라고 생각함(어짜피 i는 1부터 올라가니까 약수 중 작은 순서)
            }

            if (divisor == K) {
                System.out.println(i); //카운팅 된게 K랑 같으면 그게 K번째 약수
                break; //그냥 돌렸다가 계속 나오길레 브레이크 넣음
            }
        }

        if (divisor < K) {
            System.out.println("0");
        }

    }
}
