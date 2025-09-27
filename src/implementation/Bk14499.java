package implementation;

import java.util.*;
import java.io.*;

public class Bk14499 {

    static int n, m, k, x, y;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        x = Integer.parseInt(st.nextToken()); // 좌표x
        y = Integer.parseInt(st.nextToken()); // 좌표y
        k = Integer.parseInt(st.nextToken()); // 명령 수

        map = new int[n][m];
        dice = new int[6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int order = Integer.parseInt(st.nextToken());
            move(order - 1);
        }

        System.out.println(sb);
    }

    static void move(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 범위를 벗어난 경우 스킵
        if (nx < 0 || ny < 0 || nx >= n || ny >= m)
            return;

        int tmp = dice[5];
        switch (dir) {
            // 동
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            // 서
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            // 남
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;

            // 북
            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
        }

        sb.append(dice[0]).append("\n");

        // 좌표 업데이트
        x = nx;
        y = ny;

        // 0인경우 주사위 바닥 -> 맵
        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        }

        // map이 0이 아닌 경우 맵 -> 주사위 복사, 맵은 0으로 된다.
        else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
    }
}
