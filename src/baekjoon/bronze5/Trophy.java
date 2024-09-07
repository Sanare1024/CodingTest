package baekjoon.bronze5;

import java.util.Scanner;

public class Trophy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();// 첫째 줄에서 트로피 개수 N받기
        int [] trophy = new int [N]; // 트로피 높이 수열생성

        int maxL = 0;
        int maxR = 0;
        int left = 0;
        int right = 0; //left는 왼쪽에서 보이는 개수, right는 오른쪽, maxL은 왼쪽에서 제일큰거

        for (int i = 0; i < N; i++) {
            trophy[i] = sc.nextInt();

            if (maxL < trophy[i]) {
                left = left + 1;
                maxL = trophy[i];
            }
        }

        for (int i = N-1; i>=0; i--) {
                if (maxR < trophy[i]) {
                right = right + 1;
                maxR = trophy[i];
            }
        }

        System.out.println(left);
        System.out.println(right);
    }
}
