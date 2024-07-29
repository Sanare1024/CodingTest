package B3tr;

import java.util.Scanner;

public class Bk2738 { //1418

    public static void main(String[] args) {
        //[N][M] 크기의 행렬  A와 B 입력받고 합치기
        //행렬의 각 원소는 공백으로 구분한다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                System.out.print(A[i][j] + B[i][j] + " ");
                if(j == m - 1){
                    System.out.println(""); // 엔터
                }
            }
        }

    }
}//1430
