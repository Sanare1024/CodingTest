package B2tr;

import java.util.Scanner;

public class Bk1712 { //1029

    public static void main(String[] args) {
        //A = 고정 비용 B= 생산 비용 C = 판매비용
        //손익분기점 (존재하지 않으면 -1)
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //손익분기점이 생기지 않으려면 b가 c보다 크거나 같으면 발생
        if (b >= c) {
            System.out.println("-1");
        } else { //손익분기점은 a를 c-b 보다 1대 더 팔았을 경우
            System.out.println(a / (c - b) + 1);
        }
    }
} //1037
