package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1952 {

    static int m, n, dirft;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[m][n];
        dirft = 0;

        move(0, 0);

        System.out.println(dirft);

    }
    //우하좌상
    static int[] dx = {0,1,0,-1};//우하좌상
    static int[] dy = {1,0,-1,0};

    public static void move(int x, int y){
        visited[x][y] = true;
        int count = 1;//이동 칸수
        int dir = 0; //방향

        //우하좌상 순서로 이동
        //이동하다가 범위 밖으로 나가거나 앞이 visited면
        //dir 변경
        while(true){
            if(count == m * n) return; //탈출조건

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 ||  ny < 0 || nx >= m || ny >= n){ //벽이면
                dirft++;
                dir++;
                if(dir == 4){
                    dir = 0;
                }
                continue;
            }
            if(visited[nx][ny]){ // 앞이 간곳이면
                dirft++;
                dir++;
                if(dir == 4){
                    dir = 0;
                }
                continue;
            }
            //위에 조건이 아니라면 전진
            x = nx;
            y = ny;
            count++;
            visited[nx][ny] = true;
        }
    }
}
