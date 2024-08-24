package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk3055 {

    public static int r, c;
    public static char[][] map;
    public static boolean[][] visited;
    public static Queue<Node> q;
    public static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        q = new LinkedList<>();

        int x = 0;
        int y = 0;
        for(int i = 0; i < r; i++){
            String temp = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'S'){ // 고슴도치 시작부분
                    start = new Node(i, j, 0);
                }else if(map[i][j] == '*'){ //물 시작부분 넣어
                    q.add(new Node(i, j, 0));
                }
            }
        }
        q.add(start);// 물 다넣고 고슴도치 넣어

        bfs();
    }


    public static void bfs(){
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            //탈출조건 : 탈출
            if(map[now.x][now.y] == 'D'){ //비버굴 도착
                System.out.println(now.day);
                return;
            }
            //할일 :  물이 찰 예정인 칸으로 이동할 수 없다 이므로
            //        물퍼트리기 -> 이동 순서로 큐 빌떄까지
            if (map[now.x][now.y] == '*'){ //물 일경우
                for(int i = 0; i < 4; i++){ //퍼트리기
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;//나가면
                    if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;//벽이나 출구면
                    if(visited[nx][ny]) continue;//갔으면

                    visited[nx][ny] = true;
                    map[nx][ny] = '*';
                    q.add(new Node(nx,ny,0));
                }
            } else { //물이 아닌 땅이나 벽일경우
                for(int i = 0; i < 4; i++){ //퍼트리기
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;//나가면
                    if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;//벽이나 물이면
                    if(visited[nx][ny]) continue;//갔으면

                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny, now.day + 1));  //이동
                }
            }
        }
        System.out.println("KAKTUS"); // 큐 다돌았는데 return 안하고 여기온거면 탈출못한거
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Node{ //int y
        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
