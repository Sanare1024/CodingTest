package B3tr;

import java.util.Scanner;

public class Bk1085 { //1121

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        //현재 점 (x.y)에서 오른쪽위 꼭지점이 (w,h)인 직사각형에서 나가는 방법
        // x, y, w-x, h-y 중 제일 최솟값이 경계선까지 가는 최솟값
        int min = x;

        if (min > y) {
            min = y;
        }

        if (min > w - x) {
            min = w - x;
        }

        if (min > h - y) {
            min = h - y;
        }

        System.out.println(min);
    }
}//1125
