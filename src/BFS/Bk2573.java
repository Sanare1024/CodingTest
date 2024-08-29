package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk2573 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] ice;
    static Queue<Node> q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //빙하는 동서남북에 붙어있는 0의 개수만큼 줄어듬, 0보다 낮아지지않음
        //빙산이 주어질때 두 덩어리 이상으로 분리되는 최소의 년수를 구해라.
        //전부다 녹을때까지 덩어리가 분리 되지 않으면 0을출력
        //탈출조건 : 빙하의 조각이 2개로 나눠짐
        //진행 : 빙하를 둘러보면서 2개로 나누어 졌는지 확인(위조건 성립 탈출 후 년수 출력) > dfs
        //      -> 조건 성립안했으면 각 빙하별로 녹는거 진행 다하면서 +1년 (반복) > bfs

        int year = 0;
        while(true){
            visited = new boolean[n][m]; //빙하 둘러볼때마다 판 갈아 엎어

            int count = 0; // 빙하 조각
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && map[i][j] != 0){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            if(count >= 2){ //2개 이상으로 쪼개짐
                System.out.println(year);
                break;
            } else if (count == 0) { //다 녹음
                System.out.println(0);
                break;
            }

            //아직 빙산이 1개 녹이기 진행(1년 경과)
            bfs();
            year++;

            /*for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //나가면
            if(visited[nx][ny]) continue; //갔으면
            if(map[nx][ny] > 0){ // 빙하 만나면
                dfs(nx,ny);
            }
        }
    }

    public static void bfs(){
        q = new LinkedList<>();
        ice = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] > 0){
                    q.add(new Node(i,j));
                    ice[i][j] = true; //얼음 존재
                }
            }
        }

        while (!q.isEmpty()){
            Node nowNode = q.poll();

            //다 훑으면서 인접한 바다의 수를 센다
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;//나가면
                if(ice[nx][ny]) continue; // 빙하가 있으면
                if(map[nx][ny] == 0){
                    sea++;
                }
            }

            if (map[nowNode.x][nowNode.y] - sea < 0){
                map[nowNode.x][nowNode.y] = 0; //음수 안되니까
            } else {
                map[nowNode.x][nowNode.y] -= sea;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
