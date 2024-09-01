package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk16234 { //2012

    static int n, l, r, count;
    static boolean check;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q;
    static ArrayList<Node> union;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 돌아보면서 상하좌우에 (L < 인구차이 < R) 인지 확인 > bfs
        // 확인한 뭉치들끼리 인원 이동 실시
        // 돌면서 뭉치가 안생길때 까지 반복

        count = 0; //인원이동 횟수
        checkunion();
        System.out.println(count);
    }

    public static void checkunion(){
        while(true){ //뭉치가 안생길때까지 반복
            check = false; //연합 생기는지 확인
            visited = new boolean[n][n]; //초기화

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        creatunion(i, j);//연합 생성 실행
                    }
                }
            }
            if (!check) break; //연합이 생성 안되었으면 멈추기
            else count ++;
        }
    }

    public static void creatunion(int x, int y){
        q = new LinkedList<>();
        union = new ArrayList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        union.add(new Node(x, y)); //유니온 집합리스트

        while(!q.isEmpty()){
            Node nowNode = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = nowNode.x + dx[i];
                int ny = nowNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;  //나갔으면
                if(visited[nx][ny]) continue; //갔으면

                // 상하좌우에 있는게 l<= 인구차이 <=r 이면
                if(l <= Math.abs(map[nowNode.x][nowNode.y] - map[nx][ny])
                        && Math.abs(map[nowNode.x][nowNode.y] - map[nx][ny]) <= r){
                    check = true; //유니온 생성됨 표시
                    visited[nx][ny] = true;
                    union.add(new Node(nx,ny));
                    q.add(new Node(nx,ny));
                }
            }
        }
        //큐 다돌아서 하나의 유니온 만들었으니 인구이동
        personmove();
    }

    public static void personmove(){
        int sum = 0;
        //총합 계산
        for(int i = 0; i < union.size(); i++){
            sum += map[union.get(i).x][union.get(i).y];
        }

        for(int i = 0; i < union.size(); i++){
            map[union.get(i).x][union.get(i).y] = sum / union.size();
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
