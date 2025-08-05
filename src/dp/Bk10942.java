package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
//      int[][] dp = new int[n + 1][n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        //dp 풀이
        // 칠판에 숫자 n개, 질문 m번 반복
        // 질문 : s~e 까지 숫자가 펠린드롭? => 대칭인 숫자
        // 길이 1 = 무조건, 길이 2 = 1,2가 같으면 펠린, 3이상 = 시작 + 끝 이 같음 & 그 가운게 값이 펠린(여기서 dp발생)
        // 이러면 dp배열이 굳이 int일 이유가 없네 boolean으로 교체

        // s,e가 같은거 = 길이 1
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = true;
        }

        // s,e 가 1차이 = 길이 2
        for (int i = 1; i < n; i++) {
            if (board[i] == board[i + 1]) { // 칠판 숫자 2개 같으면
                dp[i][i + 1] = true;
            }
        }

        // 3이상
        for (int i = 2; i < n; i++) { // E
            for (int j = 1; j <= n - i; j++) { // S
                if (board[j] == board[j + i] && dp[j + 1][j + i - 1]) { //앞뒤가 같음 && 가운데 값이 펠린이면?
                    dp[j][j + i] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) { //질문 m개 받아서 대답 저장
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (dp[S][E]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
