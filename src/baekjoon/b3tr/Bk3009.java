package baekjoon.b3tr;

import java.util.Scanner;

public class Bk3009 {//1447

    public static void main(String[] args) {
        //축과 평행한 직사각형이니까 입력된좌표 3개중에 같지 않은 1가지를 합치면 좌표가 나옴
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3]; //x 좌표 저장 행렬
        int[] y = new int[3]; //y 좌표 저장 행렬

        for (int i = 0; i < 3; i++){ // 행렬에 좌표값 저장
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        if (x[0] == x[1]){
            System.out.print(x[2] + " ");
        } else if (x[1] == x[2]) {
            System.out.print(x[0] + " ");
        } else {
            System.out.print(x[1] + " ");
        }

        if (y[0] == y[1]){
            System.out.print(y[2]);
        } else if (y[1] == y[2]) {
            System.out.print(y[0]);
        } else {
            System.out.print(y[1]);
        }
    }
} //1455
