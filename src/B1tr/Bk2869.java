package B1tr;

import java.util.Scanner;

public class Bk2869 {//1341

    public static void main(String[] args) {
        //낮에 a 상승, 밤에 b 하락, 높이 v
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        /*int day = 0;
        int now = 0; //현재 높이

        while (true) {
            now += a;
            day++;

            if (now >= v) {
                break;
            }
            now -= b;
        }*/  //시간초과
        int day = (v - b) / (a - b); //하루 올라가는 거리 = a-b, v - b  = 정상도달 하루전 (나머지 있으면 +1 딱떨어지면 당일도착)
        if ((v - b) % (a - b) != 0) {
            day++;
        }

        System.out.println(day);

    }
} //1400
