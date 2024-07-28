package B4tr;

import java.util.Scanner;

public class Bk10039 { //2116

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i = 0; i < 5; i++) { //점수를 받아서 합계에 넣어 놓지만 40미만일경우 40으로 바꿈
            int a = sc.nextInt();

            if(a < 40) {
                a = 40;
            }

            sum += a;
        }

        System.out.println(sum / 5);

    }
}//2118
