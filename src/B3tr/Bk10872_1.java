package B3tr;

import java.util.Scanner;

public class Bk10872_1 {//1030 재귀로 풀기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*for(int i = 1; i <= n; i++) {
            temp = temp * i;
        }*/

        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if(n <= 1) { //0일때 1값을 리턴해야함
            return 1;
        }

        return n * factorial(n-1);
    }


}//1044
