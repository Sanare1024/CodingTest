package baekjoon.b2tr;

import java.util.Scanner;

public class Bk10811 {//1124

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //바구니 수
        int m = sc.nextInt(); //바꾸는 횟수
        int[] bucket = new int[n];

        for(int i = 0; i < n; i++) {//번호에 공넣기
            bucket[i] = i + 1;
        }

        for (int i = 0; i < m; i++){//m번 바구니 역순
            int a = sc.nextInt();
            int b = sc.nextInt();
            int temp = 0;

            while (a < b) { //a b 양끝단부터 서로 바꾸면서 a ++ b -- 해가면서 반복 a>=되면 종료
                temp = bucket[a - 1];
                bucket[a - 1] = bucket[b - 1];
                bucket[b - 1] = temp;
                a++;
                b--;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(bucket[i] + " ");
        }
    }
}//1141
