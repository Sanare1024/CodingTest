package baekjoon.b3tr;

import java.util.Scanner;

public class Bk10810 { //1438

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] bucket = new int[n];

        for (int i = 0 ; i < m; i++) { //m 회수만큼 반복
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            for (int j = a - 1; j < b; j++){ // a부터 b까지 바구니에 c공 넣기 (중복된 곳에 들어가면 알아서 새거 넣음)
                bucket[j] = c;
            }
        }

        for (int i = 0 ; i < n; i++) { // 출력
            System.out.print(bucket[i] + " ");
        }

    }
} //1444
