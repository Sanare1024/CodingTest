package B4tr;

import java.util.Scanner;

public class Bk2588 {//2332

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next(); //nextLine 쓰면 StringIndexOutOfBoundsException 떠서 next 로 바꿈

        System.out.println(a * (b.charAt(2) - 48));
        System.out.println(a * (b.charAt(1) - 48));
        System.out.println(a * (b.charAt(0) - 48));
        System.out.println(a * Integer.parseInt(b));
    }
}// 2341
