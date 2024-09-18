package LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bk9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        int[][] dp = new int[word1.length + 1][word2.length+1];

        for (int i = 1; i <= word1.length; i++) {
            for (int j = 1; j <= word2.length; j++) {

                if(word1[i-1] == word2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[word1.length][word2.length]);
        Stack<Character> stack = new Stack<>();
        int i = word1.length;
        int j = word2.length;

        while(i >= 1 && j>= 1){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                stack.push(word1[i - 1]);
                i--;
                j--;
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}