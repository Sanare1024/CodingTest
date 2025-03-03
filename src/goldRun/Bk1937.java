package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1937 {
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(i, j), max);
            }
        }
        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] > map[x][y])
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
