package Bronze5;

import java.util.Scanner;

public class APlusB1000 {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);   // 키보드로부터 입력을 받는 친구
        String s = sc.nextLine();              // 입력을 String으로 반환
        String[] strings = s.split(" "); // Sting을 공백기준으로 나눠줌 (1 2 -> {1,2})
        a = Integer.parseInt(strings[0]);      // 문자열을 숫자(int)로 치환해줌
        b = Integer.parseInt(strings[1]);      // 상동

        System.out.println(a + b);
    }
}
