package baekjoon;

import java.util.Scanner;

public class Bk2439 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= N -i; j++){
                //" " 찍는 for문
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                // *찍는 for문
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
