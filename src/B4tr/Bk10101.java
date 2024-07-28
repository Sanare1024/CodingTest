package B4tr;

import java.util.Scanner;

public class Bk10101 {//2234

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //세 각의 크기가 모두 60이면, Equilateral
        //세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
        //세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene -> 제일 표현하기 어려우니까 else
        //세 각의 합이 180이 아닌 경우에는 Error ->이게 제일 앞에 있어야 뒤에가 무조건 합이 180

        if (a + b + c != 180) {
            System.out.println("Error");
        } else if (a == b && b == c) {
            System.out.println("Equilateral");
        } else if (a == b || b == c || a == c) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }


    }
}//2240
