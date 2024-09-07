package baekjoon;

import java.util.Scanner;

public class Bk2446 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //위에 역삼각형
        for(int i = 0; i < n; i++){ //앞에 공백(첫번째는 공백0) 2*n-1개 별 (2개씩 줄어드는)

            for (int j = 0; j < i; j++) { //처음에 안나오고 1씩 증가
                System.out.print(" ");
            }

            // 맨위에 2*n-1 2개씩 줄어들기
            for (int k = 1; k <= (2 * n - 1) - (2 * i); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
        //밑에 삼각형 붙이기
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < (n - 1) - i ; j++) { //처음에 3개 나오고 1개씩 줄고 마지막안나옴
                System.out.print(" ");
            }

            // 3부터 시작해서 2씩 늘어나기 =빼서 마지막이 2n-1
            for (int k = 0; k < 3 + (2 * i); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
