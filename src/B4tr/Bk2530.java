package B4tr;

import java.util.Scanner;

public class Bk2530 {//2240

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        // 시각의 시, 분, 초을 공백을 사이에 두고 출력 디지털 시계는 23시 59분 59초에서 1초가 지나면 0시 0분 0초가 된다.
        b = b + d / 60; //걸린시간 일단 분으로 만들어서 넣고
        c = c + d % 60; //남은초 c에 넣고

        b = b + c / 60; //c 넘쳤을 경우 대비
        c = c % 60; // 남은 c정리

        a = a + b / 60; //b 넘친거 a로 옮기기
        b = b % 60; // 남은 b정리

        a = a % 24; //조건에 24넘었을때 생각해서 정리

        System.out.print(a + " " + b + " " + c);
    }
} //2248
