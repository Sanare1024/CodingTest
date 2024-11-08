package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk2293 {

    static int n, k;
    static int[] coinValue;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coinValue = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        //코인 개수만큼 반복
        for (int i = 1; i <= n; i++) {
            // 코인 1개씩 돌아가면서 1부터 k까지 총합을 할때 나오는 경우의 수를 저장해 나감
            for (int j = 1; j <= k; j++) {
                if (j < coinValue[i]) continue; // 총합이 코인의 크기보다 작으면 패스
                dp[j] = dp[j] + dp[j - coinValue[i]]; //ex : dp[3] = dp[3] + d[1] // (1,2원짜리로 표현한 경우의 수) = (기존의 1원짜리로 표현가능한 수) + dp[1]
            }
        }

        System.out.println(dp[k]);
    }
}
