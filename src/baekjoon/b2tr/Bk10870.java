package baekjoon.b2tr;

import java.util.Scanner;

public class Bk10870 {//0949

    public static void main(String[] args) {
        //피보나치 수열 만들기 Fn = Fn-1 + Fn-2 (n ≥ 2)
        //입력 n - > n번째 피보나치 수열
        //0과 1은 고정값
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));

    }

    static int fibonacci (int n){ // n은 20보다 작거나 같은 자연수 또는 0
        if(n < 2) return n;

       return fibonacci(n-1) + fibonacci(n - 2);
    }
} //1005
