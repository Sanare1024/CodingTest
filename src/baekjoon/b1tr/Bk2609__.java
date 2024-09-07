package baekjoon.b1tr;

import java.util.Arrays;
import java.util.Scanner;

public class Bk2609__ { //1402

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        Arrays.sort(arr);
        int a = arr[0]; //작은수
        int b = arr[1]; //큰수
        int max = 0; //최대 공약수
        int min = 0; //최소 공배수


        //최대공약수
        for (int i = b; i > 0; i--){
            if(b % i == 0 && a % i == 0){
                max = i;
                break;
            }
        }
        //최소공배수
       /* for (int i = 1; i < b; i++) { 조건이 문제였음
            if ((b * i) % a == 0) {
                min = b * i;
                break;
            }
        }*/
        int i = 0;
        while (true) {
            i++;
            if ((b * i) % a == 0) {
                min = b * i;
                break;
            }
        }

        System.out.println(max);
        System.out.println(min);


    }
}//1424 98퍼에서 틀렸습니다 1435까지 시도해봤으나 안됨 일단 패스
