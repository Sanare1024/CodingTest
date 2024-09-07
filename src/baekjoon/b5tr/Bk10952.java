package baekjoon.b5tr;

import java.util.Scanner;

public class Bk10952 {//1457

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {//0 0 입력받을때까지 무한정돌아가게
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 0 && b == 0){//0 0 받을때 멈추기
                break;
            }
            // & - 비트연산 && - 일반연산

            System.out.println(a + b); //0 0은 출력안되게 if보다 밑에 배치
        }
    }
} //1501
