package dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1062 {

    static int n, k;
    static int maxWord;
    static boolean[] alpha = new boolean[26];
    static String[] wordList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        wordList = new String[n];
        maxWord = 0;

        for (int i = 0; i < n; i++) {
            wordList[i] = br.readLine();
        }

        //a n t i c 는 항상 들어감
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;

        if (k < 5){ // 5개미만이면 a n t i c 못배우니까 안됨
            System.out.println(maxWord);
        } else {
            dfs(0, 0);
            System.out.println(maxWord);
        }
    }

    public static void dfs(int index, int count) {
        //탈출조건
        if(count + 5 == k){
            //조건맞으면 읽을 수 있는 단어 개수 계산해보기
            int cntWord = 0;
            for (int i = 0; i < n; i++){
                char[] aplhas = wordList[i].toCharArray();
                boolean check = true;

                for (char c : aplhas) {
                    if (!alpha[c - 'a']){
                        check = false;
                        break;
                    }
                }

                if (check) {
                    cntWord++;
                }
            }

            maxWord = Math.max(maxWord, cntWord);
        }

        //반복 - 조합
        for (int i = index; i < 26; i++){ //
            if (alpha[i]) continue; //이미 뽑은건 패스

            alpha[i] = true;
            dfs(i + 1, count + 1); //뽑기
            alpha[i] = false; // 풀기
        }
    }
}
