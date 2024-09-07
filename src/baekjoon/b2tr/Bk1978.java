package baekjoon.b2tr;

import java.util.Scanner;

public class Bk1978 { //2328

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0; //소수 셀 곳



        for (int i = 0; i < n; i ++){
            int num = sc.nextInt();
            boolean Prime = true; // 소수인지 체크포인트

            if (num == 1) { // 1은 예외대상
                continue;
            }

            for (int j = 2; j < num; j++) {
                if(num % j == 0){
                    Prime = false; // false로 바뀌면 소수 아님
                    break;
                }
            }

            if (Prime) { //prime이 true면 소수
                count ++;
            }
        }

        System.out.println(count);
    }
} //2342
