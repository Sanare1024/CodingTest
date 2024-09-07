package baekjoon.b3tr;

import java.util.Scanner;

public class Bk10250 {//1344

    public static void main(String[] args) { //1347 글 3분
        // 옆으로 12 높이 6
        //차는순서는 같은 XX번호에서 Y순으로
        //N번째 손님이 받을 방 번호
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 케이스 수

        int y;
        int x;

        for (int i = 0; i < t; i++) { //테스트 수만큼 받아야함
            int h = sc.nextInt(); //호텔 층수
            int w = sc.nextInt(); // 호텔 끝방번호
            int n = sc.nextInt(); // N번째 손님

            //방번호는 YXX나 YYXX (h w 가 99이하)
            //N 번째 손님 x = (n / h) + 1   y = (n % h) * 100(나머지가 0이면 꼭대기층이니까 h * 100, x도 그냥 n / h)
            if (n % h == 0) {
                x = n / h;
                y = h * 100;
            } else {
                x = (n / h) + 1;
                y = (n % h) * 100;
            }

            System.out.println(x + y);
        }
    }
} //1406
