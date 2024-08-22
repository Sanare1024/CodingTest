package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk2206 {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited= new boolean[n][m][2];

        for (int i = 0; i < n; i++){
            String temp = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(new Node(0, 0, 1, false));

        if (ans == Integer.MAX_VALUE){ // 끝까지 못갔을때 ans 갱신 안되었으니까 Max.value인 상태
            System.out.println(-1);
        } else { // 갱신된경우 = 끝까지 도착한것
            System.out.println(ans);
        }

    }

    public static void bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y][0] = true;

        while (!q.isEmpty()){
            Node nowNode = q.poll();

            //탈출조건 : 끝에 가면
            if(nowNode.x == n - 1 && nowNode.y == m - 1){
                ans = Math.min(ans, nowNode.len);
            }
            //할일 : 돌면서 벽부수기 or 안부수기 다 돌어서 len거리 측정
            for(int i = 0; i < 4; i++){
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;//나가면
                //벽인데 내가 안부셨다(count =0 ) 그러면 부수고(count = 1) q에 add
                // 1.이동한 곳이 갈 수 있는곳 -> (1)벽을 안부수고 온경우 (2)벽을 부순경우 
                // 2.이동한 곳이 벽일경우 -> (1)벽 안부수고 온경우 (2) 부순경우 
                if(map[nx][ny] == 0){// 1.이동한 곳이 갈 수 있는곳
                    if(!visited[nx][ny][0] && !nowNode.broken){ // 안갔음 + 벽을 안부순 차원
                        q.add(new Node(nx,ny, nowNode.len + 1, false ));
                        visited[nx][ny][0] = true;
                    } else if(!visited[nx][ny][1] && nowNode.broken){ // 안갔음 + 부수고 온 차원
                        q.add(new Node(nx,ny, nowNode.len + 1, true ));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == 1) { // 2. 이동한곳이 벽일경우
                    if(!nowNode.broken){// (안갔음)벽은 1번만 부술 수 있으니까 visited필요없 + 벽을 안부순 차원
                        q.add(new Node(nx,ny, nowNode.len + 1, true )); //부수고 진행하면서 큐에 넣

                    }
                }
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;
        int len;
        boolean broken;

        public Node(int x, int y, int len, boolean broken) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.broken = broken;
        }
    }
}
