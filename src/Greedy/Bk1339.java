package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk1339 {

    static int n;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        alpha = new int[26];
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            // 글자 AAA 111
            // 글자 ABCDE 10000 1000 100 10 1
            int temp = 1;
            for(int j = word.length() - 1; j >= 0; j--){ //밑에서부터
                alpha[word.charAt(j) - 'A'] += temp;
                temp *= 10;
            }
        }
        //지금은 정직하게 유형보고 유형대로 풀어\
        //그리디 알고리즘 대표적인 친구들이 있음
        //그래프 탐색, 내가 제일 짧은길로만 가면 이득이다,
        //가방채우기 알고리즘 knapsack 무게 제한 100, 최대한 높은 가치로 담는 방법


        Arrays.sort(alpha); // 정렬때려서 큰수가 뒤로가게

        int res = 0;
        int j = 9;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if(alpha[i] == 0) break;
            res += j * alpha[i];
            j--;
        }

        System.out.println(res);
    }


}
