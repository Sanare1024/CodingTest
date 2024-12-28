package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk7569 {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int[][][] box;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < m; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) q.add(new Node(k, j, i));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()){
            Node nowNode = q.poll();

            int x = nowNode.x;
            int y = nowNode.y;
            int z = nowNode.z;

            for(int i = 0 ; i < 6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;
                if (box[nz][ny][nx] != 0) continue;

                q.add(new Node(nx, ny, nz));
                box[nz][ny][nx] = box[z][y][x] + 1;
            }
        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                    if(box[i][j][k] == 0) return -1;
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        // 최대 값이 1이라면 원래부터 모두 익어있었다는 것
        if(result == 1) return 0;
            // (최대 값 - 1) --> 걸린 일수
        else return (result - 1);
    }

    static class Node{
        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}


