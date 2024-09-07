package baekjoon.b2tr;

import java.util.Scanner;

public class Bk3052 {//1529

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int count = 0;

        for (int i = 0; i < 10; i++){
            arr[i] = sc.nextInt() % 42;
        }

        for (int i = 0; i < 10 ; i++){
            int temp = 0;  //판별값 초기화

            for(int j = i + 1; j < 10; j++) {
                if(arr[i] == arr[j]) {// i 랑 i+1을 비교해서 같으면 temp 증가
                    temp++;
                    break;
                }
            }

            if(temp == 0) {
                count ++;
            }

        }

        System.out.println(count);
    }
}//1557
