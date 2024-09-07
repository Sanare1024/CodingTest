package baekjoon.bronze5;

import java.util.Scanner;

public class AMB1001 {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        a = Integer.parseInt(strings[0]);
        b = Integer.parseInt(strings[1]);

        System.out.println(a - b);
    }
}
