package B4tr;

import java.util.Scanner;

public class Bk10156 {//2256

    public static void main(String[] args) {
        //과자 한 개의 가격이 K, 사려고 하는 과자의 개수가 N이고, 현재 가진 돈의 액수를 M
        //모자란 가격 출력 안 모자르면 0
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int total =  k * n;

        if (m >= total) {
            System.out.println(0);
        } else {
            System.out.println(total - m);
        }

    }
}//2300
