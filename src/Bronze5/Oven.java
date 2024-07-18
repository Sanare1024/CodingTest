package Bronze5;

import java.util.Scanner;

public class Oven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 시
        int B = sc.nextInt(); // 분
        int C = sc.nextInt(); // 소요시간

        int total = A * 60 + B;
        total = total + C;

        int hour = (total / 60) % 24;
        int min =  total % 60;

        System.out.println(hour + " " + min);
    }
}
