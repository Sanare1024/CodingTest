package baekjoon.b3tr;

import java.util.Scanner;

public class Bk2566 {//1518

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int max = 0; // 최대값 받을곳
        int x = 0; //위치 x
        int y = 0; //위치 y


        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max < arr[i][j]){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((x + 1) + " " + (y + 1));
    }
} //1522
