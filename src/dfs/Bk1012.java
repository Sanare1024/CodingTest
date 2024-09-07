package dfs;

import java.util.Scanner;

public class Bk1012 {

    static int m,n; // 밭 가로세로
    static boolean[][] visited; //간곳체크
    static int[][] field; //밭

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt(); //배추개수

            field = new int[m][n]; //테스트 케이스마다 새로해야하니까 여기에
            visited = new boolean[m][n];
            int worm = 0; //지렁이 개수

            //배추심기
            for(int i = 0; i < k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1;
            }

            //배추 그룹 찾기
            for(int y = 0; y < n; y++) {
                for(int x = 0; x<m; x++){
                    if(!visited[x][y] && field[x][y] == 1){ //안가본곳이면서 필드에 배추가 있을떄 재귀 실행
                        visited[x][y] = true;
                        move(x,y);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }
    }
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};

    public static void move(int x, int y) {

        for (int i = 0; i < 4; i++) {//상하좌우 위로간 좌표 밑으로간거 옆 오른쪽

            int nx = x + dx[i];
            int ny = y + dy[i];

            //인덱스 나가는거 를 방지해줘야해
            if(nx < 0 ||  ny < 0 || nx >= m || ny >= n) continue;
            //여기 갔던데네?
            if(visited[nx][ny]) continue;
            //배추가 없으면
            if(field[nx][ny] == 0) continue;
            visited[nx][ny] = true;
            move(nx,ny);
        }
    }
}
