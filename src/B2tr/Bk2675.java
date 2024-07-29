package B2tr;

import java.util.Scanner;

public class Bk2675 {//2216

    public static void main(String[] args) {
        //테스트횟수 t ,  반복횟수 r 문자열P 받고 r씩 반복
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String str = sc.next();  //nextLine 쓰면 공백도 읽음

            for (int j = 0; j < str.length(); j++) { //단어마다
                for (int k = 0; k < r; k++) { //r번씩 반복
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
} //2224
