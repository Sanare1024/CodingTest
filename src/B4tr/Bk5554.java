package B4tr;

import java.util.Scanner;

public class Bk5554 {//2306

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int total = a + b + c + d;

        System.out.println(total / 60);
        System.out.println(total % 60);
    }
}//2308
