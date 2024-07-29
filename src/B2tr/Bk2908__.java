package B2tr;

import java.util.Scanner;

public class Bk2908__ {//2246

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int reA = (a % 10) * 100 + ((a % 100)/10) * 10 + a / 100;
        int reB = (b % 10) * 100 + ((b % 100)/10) * 10 + b / 100;

        if ( reA > reB) {
            System.out.println(reA);
        } else { //조건에 두 수는 같지 않은 세자리 수 이며 0이 포함되어 있지 않다고 해서 그냥 else함
            System.out.println(reB);
        }

    } // 더 깔끔하고 이쁘게 푸는 방법이 있을건데 모름... 알려주세요
} //2253
