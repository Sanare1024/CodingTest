package dfs;

import java.io.IOException;
import java.util.Scanner;

public class Practice {

    static int N;
    static int[] result;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        result = new int[]{-1, -1}; //x y 받을 곳

        N = sc.nextInt();
        visited = new boolean[N][N];
        map = new int[N][N]; //x y 받을려고
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //DFS 숫자를 받고 맨처음 갔다고 표현
        visited[0][0] = true;
        recur(0,0);
        System.out.println("y: " + result[0] + " x: " + result[1]);
    }

    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};

    //밑에 재귀를 만들어준다
    //재귀 기본조건 =  탈출조건, 내가 할일

    //DFS 도착하면 최단거리가 아닐수도 있어, 딴데를 해봐야할 수 도있어
    //그런데, 도착만 하면되는 문제라면? 뒤를 갈필요가? 내가 정답을 찾았을때 바로 멈추는것,또는 더 갈필요가 없을떄 멈추는걸
    //가지치기.


    public static void recur(int y, int x) {
        //탈출조건
        if (map[y][x] == 1) {
            result[0] = y;
            result[1] = x;
            return;
        }

        for (int i = 0; i < 4; i++) {//상하좌우 위로간 좌표 밑으로간거 옆 오른쪽
            int nx = x + dx[i];
            int ny = y + dy[i];
            //인덱스 나가는거 를 방지해줘야해
            if(nx < 0 ||  ny < 0 || nx >= N || ny >= N) continue;
            //여기 갔던데네?
            if(visited[ny][nx]) continue;
            if(map[ny][nx] == 0) continue;
            visited[ny][nx] = true;//나 갈거야! 표시
            recur(ny,nx);//나 갔어!
        }
    }

}