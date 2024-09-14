package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk1600 { //2223

    static int k, w, h;
    static int moveCount;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        moveCount = Integer.MAX_VALUE;

        dfs();

        if (moveCount == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(moveCount);
        }

    }

    public static void dfs(){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[h][w][k + 1];

        q.add(new Node(0,0, 0, 0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            Node nowNode = q.poll();
            //탈출조건
            if(nowNode.x == w - 1 && nowNode.y == h - 1){
                moveCount = nowNode.move;
                return;
            }
            //할일
            if(nowNode.horse < k){ // 말모양 이동
                for(int i = 0; i < 8; i++){
                    int nx = nowNode.x + horseX[i];
                    int ny = nowNode.y + horseY[i];

                    if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue; //나가면
                    if(visited[ny][nx][nowNode.horse + 1]) continue; // 갔으면
                    if(map[ny][nx] == 1) continue; // 벽이면
                    visited[ny][nx][nowNode.horse + 1] = true;
                    q.add(new Node(nx, ny, nowNode.horse + 1, nowNode.move + 1));
                }
            }
            // 말 이동 없으면
            for(int i = 0; i < 4; i++){
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue; //나가면
                if(visited[ny][nx][nowNode.horse]) continue; // 갔으면
                if(map[ny][nx] == 1) continue; // 벽이면
                visited[ny][nx][nowNode.horse] = true;
                q.add(new Node(nx, ny, nowNode.horse, nowNode.move + 1));
            }

        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] horseX = {-1,-2,1,2,-1,-2,1,2};
    static int[] horseY = {-2,-1,-2,-1,2,1,2,1};

    static class Node{
        int x;
        int y;
        int horse;
        int move;

        public Node(int x, int y, int horse, int move) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.move = move;
        }
    }
}
