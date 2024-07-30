package B1tr;

import java.util.Scanner;

public class Bk11653 {//1451

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 2; i <= n; i++) { //2부터 계속 나눠보면서 나머지가 0 일때 값출력
            while(n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
        }

    }
} //1503
