package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n]; // n번째 행렬의 크기
        int[][] dp = new int[n][n]; // i번째 ~ j번째까지 곱셈 연산 최소 수

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[i][0] = a;
            matrix[i][1] = b;
        } // 행렬 크기 세팅

        //연산 횟수 =
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for (int next = 2; next < n; next++) { // 간격을 2부터 n-1까지
            for (int i = 0; i + next < n; i++) { // i번째
                int j = i + next; // 다음 연산 범위 마지막 행렬
                dp[i][j] = Integer.MAX_VALUE; // 일단 큰 값으로 주기

                for (int k = i; k < j; k++) { // i와 j사이에서 연산할 행렬들
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
                } // 이미 있는 값과, 새로운 연산 결과를 비교, 최소값을 채용
                // 새로운 결과 = 두 행렬의 dp값의 합 + i의 행 * k+1의 행(=k번째의 열) * j의 열
            }
        }
        System.out.println(dp[0][n - 1] + "\n"); // 0~n-1까지의 최소 연산 결과 출력
    }
}
