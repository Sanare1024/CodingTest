package B2tr;

import java.util.Scanner;

public class Bk2577__ {//2228

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int answer = a * b * c;

        String str = Integer.toString(answer); // 이거 모르겠어서 10분쓰고 검색함

        for( int i = 0; i < 10; i++) { // 0 부터 9 까지

            int count = 0; //돌때마다 0으로 초기화
            for(int j = 0; j < str.length(); j++) {
                if((str.charAt(j) - 48) == i) {
                    count++;
                }
            }

            System.out.println(count);
        }


    }
} //2243
