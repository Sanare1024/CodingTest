package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk3109 {

    static int r, c;
    static char[][] map;
    static int res;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            if (map[i][0] == 'x') continue;
            res += dfs(i, 0);
        }

        System.out.println(res);
    }

    static int dfs(int x, int y) {
        if (y == c - 1) {
            return 1;
        }

        map[x][y] = 'x';
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if (nx < 0 || nx >= r) continue;
            if (map[nx][ny] == 'x') continue;
            if (dfs(nx, ny) == 1) {
                return 1;
            }
        }

        return 0;
    }
}
