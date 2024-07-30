package B1tr;

import java.util.Scanner;

public class Bk1157 { //1302

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26]; //알파벳 받을 곳
        String str = sc.next();

        //System.out.println(((int)'A'));       확인용
        for (int i = 0; i < str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') { //대문자일 경우
                alpha[str.charAt(i) - 'A']++;
            } else { //소문자일 경우
                alpha[str.charAt(i) - 'a']++;
            }
        }

        int max = 0; //최대값 확인
        char answer = '?'; //정답이 문자니까 char

        for (int i = 0; i < alpha.length; i++){
            if (alpha[i] > max) {
                max = alpha[i];
                answer = (char) (i + 65); //이거 미리 안배웠으면 못했을듯
            } else if (alpha[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
} //1321
