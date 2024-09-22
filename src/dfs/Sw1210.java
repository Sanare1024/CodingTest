package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1210 {

    static int res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++){
            int testCase = Integer.parseInt(br.readLine());

            map = new int[100][100];
            int endY = 0;
            int endX = 0;

            for (int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2){
                        endY = i;
                        endX = j;
                    }
                }
            }
            move(endY, endX);

            System.out.println("#" + testCase + " " + res);
        }
    }

    static int[] dy = {0,0,-1};
    static int[] dx = {-1,1,0}; //좌우상 거꾸로 올라가서 하필요없음

    public static void move (int y, int x){
        // 재귀로 푸니까 스택오버플로뜸
        while(true){
            if (y == 0){ //맨위 도착
                res = x;
                break;
            }
            for (int i = 0; i < 3; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100) continue;
                if (map[ny][nx] != 1) continue;
                map[y][x] = -1; //지나온길 바꾸고
                y = ny;
                x = nx;
            }
        }
    }

}
