package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk14502 {

    static int n, m;
    static int[][] map;
    static int[][] copymap;
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dfs 조합으로 벽세우기 ((dfs탈출조건) bfs 바이러스 퍼트리기 ((바이러스 다 퍼지고) 안전구역 체크해서 개수 세서 minvalue랑 비교해서 최대값저장))

        dfs(0);

        //dfs가 끝나서 여기온거면 조합별로 bfs다돌려서 res값 다 갱신한거겠지
        System.out.println(res);
    }

    public static void dfs(int wall){
        if(wall == 3){ //조건 : 벽이 3개 설치했으면
            //체크용 출력
           /* for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }*/
            bfs(); //바이러스 퍼트리기

            return;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();

        //Deep copy
        copymap = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                copymap[i][j] = map[i][j];
            }
        }


        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(copymap[i][j] == 2){
                    q.add(new Node(i,j)); //바이러스 위치 큐에 넣
                }
            }
        }

        while (!q.isEmpty()){
            Node cNode = q.poll();

            //탈출조건x (전부전염)
            //할일 전염
            for(int i = 0; i < 4; i++){
                int nx = cNode.x + dx[i];
                int ny = cNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;//나가면
                if(copymap[nx][ny] == 1 || copymap[nx][ny] == 2) continue;// 벽 or 감연된 곳이면

                copymap[nx][ny] = 2;
                q.add(new Node(nx,ny));
            }
        }

        //큐 다돔 = 감염 다시킴
        int count = 0; // 감염 안된곳 찾을곳
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(copymap[i][j] == 0){
                    count++;
                }
            }
        }//카운팅 다함
        res = Math.max(res,count); //나온 카운트값으로 최대값 비교해서 갱신.
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
