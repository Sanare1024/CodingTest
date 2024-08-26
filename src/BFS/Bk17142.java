package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;

public class Bk17142 {

    static int n, m;
    static int blank;
    static int[][] map;
    static int[][] copymap;
    static boolean[][] visited;
    static int res = Integer.MAX_VALUE;
    static ArrayList<Node> nuu;
    static Node[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nuu = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        selected = new Node[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    blank++;
                }
                if(map[i][j] ==2){
                    nuu.add(new Node(i,j,0));
                }
            }
        }
        if(blank == 0){
            System.out.println(0);
            return;
        }

        // 입력---------------------------------
        //dfs 조합으로 바이러스 m개 선택 > bfs 바이러스 퍼트리기 걸린일수 최소값 갱신

        dfs(0 , 0);

        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void dfs(int virus, int start){
        //탈출조건
        if(virus == m){ //바이러스 m개 선택
            /*//체크용
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
            bfs();
            return;
        }
        //조합 돌리기 //
        for(int i = start; i < nuu.size(); i++){
            selected[virus] = nuu.get(i);
            dfs(virus + 1, i + 1);
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][n];
        int day = 0;
        int tempblank = blank;

        //깊복
        copymap = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copymap[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            copymap[selected[i].x][selected[i].y] = 3;
        }

        //큐 넣
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(copymap[i][j] == 3){
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Node nowNode = q.poll();
            day = nowNode.day;

            //할일 전염
            for(int i = 0; i < 4; i++){
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];
                int nday = nowNode.day + 1;

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;//나가면
                if(copymap[nx][ny] == 1) continue;// 벽이면
                if(visited[nx][ny]) continue; //갔으면
                if(copymap[nx][ny] == 0){
                    copymap[nx][ny] = 2;
                    visited[nx][ny] = true;
                    tempblank--;
                    if(tempblank == 0){
                        res = Math.min(res,nday);
                        return;
                    }
                    q.add(new Node(nx, ny, nday));
                } else  {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, nday));
                }
            }
        }


    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;
        int day;

        public Node(int x, int y,int day) {
            this.x = x;
            this.y = y;
            this.day = day;

        }
    }
}
