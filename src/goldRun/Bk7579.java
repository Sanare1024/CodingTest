package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;

        int[] memoryList = new int[n];
        int[] costList = new int[n];
        int[][] dp = new int[n][100001];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            memoryList[i] = Integer.parseInt(st1.nextToken());
            costList[i] = Integer.parseInt(st2.nextToken());
        }


        for (int i = 0; i < n; i++) {
            int cost = costList[i];
            int memory = memoryList[i];


            for (int j = 0; j <= 10000; j++) {
                // 앱이 하나일 경우 예외처리
                if (i == 0) {
                    if (j >= cost) dp[i][j] = memory;
                } else {
                    if (j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }

                // 주어진 필요한 메모리보다 확보가능한 메모리가 클 경우 정답으로 저장
                if (dp[i][j] >= m) ans = Math.min(ans, j);
            }
        }
        System.out.println(ans);
    }
}
