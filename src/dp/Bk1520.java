package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1520 {

    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(DFS(0, 0));


    }

    public static int DFS(int x, int y) {
        //탈출조건
        if(x == n - 1 && y == m - 1) return 1; //끝자리는 경우의수가 1
        //반복
        if(dp[x][y] == -1) {
            dp[x][y] = 0; //처음 도착한 곳은 0으로 초기화
            for (int i = 0; i < dx.length; i++) {
                int nr = x + dx[i];
                int nc = y + dy[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                if(map[x][y] > map[nr][nc]) {//내리막길인 경우에만
                    dp[x][y] += DFS(nr,nc);// 내가 가려는 위치의 경우의 수를 더해줘.
                }
            }
        }
        return dp[x][y];
    }
}
