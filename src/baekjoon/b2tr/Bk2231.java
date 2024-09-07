package baekjoon.b2tr;

import java.io.IOException;
import java.util.Scanner;

public class Bk2231 { //1006

    public static void main(String[] args) throws IOException {
        //N의 분해합은 N과 N을 이루는 각 자리수의 합
        //어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자
        //첫째 줄에 답을 출력 생성자가 없는 경우에는 0을 출력
        //자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 0; // 정답(가장 작은 생성자)

        for(int i = 1; i < n ; i++) {
            int num = i;
            int sum = 0; // 각 자리수의 합 저장할곳 초기화

            while(num != 0) { //10씩나누고 %10 연산하면서 반복하면 각자리 수를 알수 있고 i = 0 될때 끝남
                sum += num % 10;
                num = num / 10;
            }

            if (sum + i == n) {  // 각자리수의 합 sum과 i의 합이 n 이면 i는 n의 최소 생성자
                min = i;
                break; //break하면 최소값들어감
            }
        }
        System.out.println(min);
    }
} //1021 시간초과  //1028해결
