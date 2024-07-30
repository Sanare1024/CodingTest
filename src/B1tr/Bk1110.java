package B1tr;

import java.util.Scanner;

public class Bk1110 {//1146

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cycle = 0; //사이클 저장용
        int start = n; // 시작값 저장용

        while(true) { //조건 달성까지 무한
            n = n % 10 * 10 + (n / 10 + n % 10) % 10; //앞에 괄호 = 주어진 수의 오른쪽 자리수, 뒤에 괄호 = 각자리 숫자 더한값의 오른쪽 자리수
            cycle++;

            if (n == start){ //원래값과 같아지면
                break;
            }
        }

        System.out.println(cycle);
    }
} //1159
