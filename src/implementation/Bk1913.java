package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk1913 {

    static int n, findNum, start;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());
        map = new int[n][n];

        start = 1;
        drowSnail(n / 2, n / 2, 1, 0, 0);
        printAns();

    }
    //중앙 = map[n/2][n/2]  홀수니까 무조건 여기
    //중앙에서부터 상우하좌 순서
    //1칸 가는걸 2번 -> 2칸가는걸 2번 -> n칸을 2번 반복
    static int[] dx = {-1,0,1,0};//상우하좌
    static int[] dy = {0,1,0,-1};

    public static void drowSnail(int x, int y, int repeat, int dir, int count){
        if (start - 1 == n * n) return;
        for(int i = 0; i < repeat; i++){
            map[x][y] = start;
            start++;
            x = x + dx[dir];
            y = y + dy[dir];
        }
        dir++;
        if(dir == 4){
            dir = 0;
        }

        count++;
        if(count == 2){
            repeat++;
            count = 0;
        }

        drowSnail(x, y, repeat, dir, count);
    }

    public static void printAns(){
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]).append(" ");
                if(map[i][j] == findNum){
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }


}
