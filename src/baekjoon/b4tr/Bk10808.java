package baekjoon.b4tr;

import java.util.Scanner;

public class Bk10808 {//2143

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine(); //baekjoon
        int[] alpha = new int[26];

        for(int i = 0; i <word.length(); i++) {
            int a = word.charAt(i) - 97;
            alpha[a]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
