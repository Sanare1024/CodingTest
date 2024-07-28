package B4tr;

import java.util.Scanner;

public class Bk2480 { //2042

    public static void main(String[] args) {
        //같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        //같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        //모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && b == c && c == a) { //같은눈 3개
            System.out.println(10000 + a * 1000);
        } else if (a == b || a == c) { //같은눈 2개
            System.out.println(1000 + 100 * a);
        } else if (b == c) { //같은눈 2개
            System.out.println(1000 + 100 * b);
        } else { //다 다를때 최대값
            int max = a;
            if (max < b) {
                max = b;
            }
            if (max < c) {
                max = c;
            }
            System.out.println(max * 100);
        }

    }
} //2052
