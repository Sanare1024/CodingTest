package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk2638 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Node> cheese;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cheese = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) { //치즈면 가져가기
                    cheese.add(new Node(i, j));
                }
            }
        }

        int totalTime = 0;
        while (!cheese.isEmpty()) {
            visited = new boolean[n][m];
            checkOutside(0, 0);
            melt();
            totalTime++;
        }

        System.out.println(totalTime);
    }

    public static void checkOutside(int x, int y) {
        visited[x][y] = true; //간곳 체크
        map[x][y] = -1; //외부공기로 체크 = -1

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 나가면 스킵
            if (visited[nx][ny]) continue; //간곳 스킵
            if (map[nx][ny] == 1) continue; //치즈 스킵
            checkOutside(nx, ny);
        }
    }

    public static void melt() {
        for (int i = 0; i < cheese.size(); i++) { // 치즈 개수만큼 녹이기 실시
            int x = cheese.get(i).x;
            int y = cheese.get(i).y;
            int meltCount = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (map[nx][ny] == -1) { //4방향 탐색해서 외부공기 2개면 녹는 치즈
                    meltCount++;
                }
            }

            if (meltCount >= 2) {
                map[x][y] = 0;
                cheese.remove(i);
                i--; // 리스트에서 지워서 땡겨져야함
            }
        }
    }
}
