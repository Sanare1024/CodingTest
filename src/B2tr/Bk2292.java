package B2tr;

import java.util.Scanner;

public class Bk2292 { //2348

    public static void main(String[] args) {
        // 벌집에서 한 바퀴 감길 때 마다 거리는 1씩 증가
        // 1 이후 6 12 18 24
        // 1은 예외처리 후
        // n 을 /6 했을때 안됨
        // 바퀴 수로 감아서 어느 범위 안에 들어오면 끊기게
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 1; //벌집번호
        int b = 0; //감긴 횟수 (b + 1 = 정답)

        while (n != 1) { //n 이 1이면 실행되면 안됨

            a += (b * 6); // 바퀴 올라갈때마다 6 12 씩 들어가겠지
            if(n <= a) break; // n이 a범위 안에 들어오면 멈추고
            b++;
        }

        System.out.println(b + 1);
    }
} //0013  생각하고 구현하는데 너무 오래걸림 어려워....
