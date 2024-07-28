package B4tr;

import java.util.Scanner;

public class Bk10797 {//2251

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //날짜 숫자
        int count = 0; //위반차 카운팅

        //차량은 5대   번호는 0~9 숫자
        for (int i = 0; i < 5; i++) {
            int car = sc.nextInt();
            if(a == car) {
                count++;
            }
        }

        System.out.println(count);
    }
}//2254
