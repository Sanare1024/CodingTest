package baekjoon.b1tr;

import java.util.Scanner;

public class Bk2775 {//1436

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 케이스

        int[][] APT = new int[15][15]; // 앞이 층 뒤에가 호, 1<= k,n && kn <= 14
        for(int i = 0; i < 15; i++){
            APT[i][1] = 1; // i층 1호는 무조건 다 1
            APT[0][i] = i; // 0층 i호
        }

        for(int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
            }
        }

        for(int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(APT[k][n]);
        }
    }
} //1449 어제봐둬서 대가리 굴러감
