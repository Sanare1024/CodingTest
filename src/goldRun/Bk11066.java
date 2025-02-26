package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11066 { //파일 합치기
    //소설의 각 챕터이므로 무조건 인접한 것끼리 묶어야 한다.
    //규칙상 마지막 연산은 전체합을 더해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // 장의 수
            int[] files = new int[K];
            int[] sum = new int[K + 1];

            // 파일 크기 입력 및 누적 합 계산
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i + 1] = sum[i] + files[i];
            }

            // DP 테이블 초기화
            int[][] dp = new int[K][K];

            // 길이에 따라 최소 비용 계산
            for (int len = 1; len < K; len++) {
                for (int i = 0; i + len < K; i++) {
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                    }
                }
            }

            // 결과 출력
            System.out.println(dp[0][K - 1]);
        }
    }
}
