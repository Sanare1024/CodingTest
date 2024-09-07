package baekjoon.bronze5;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine(); // word를 받아
        String[] w = word.split(""); // 나눠서 배열에 넣어
        int wordLength = word.length(); // 단어의 글자 수

        String[] wRe = new String[wordLength]; //거꾸로 배열

        for (int i = 0; i < wordLength; i++) { //단어 뒤집는중
            wRe[i] = w[wordLength - i -1];
        }

        String wordR = String.join("",wRe); //배열 String으로 변환

        int answer = 0; // 맞을경우 1로 상정하고 틀리면 0 으로 바꿔

        if(word.equals(wordR)) {
            answer = 1;
        }

        System.out.println(answer);
    }
}
