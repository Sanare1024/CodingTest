package dfs;

import java.util.Scanner;

public class Bk2468 { //2113

    static int n; //가로세로
    static boolean[][] flood; //침수
    static int [][] zip;  //집
    static int dry; //침수지역 최대값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        zip = new int[n][n];

        int max = 0;
        //높이 받
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                zip[i][j] = sc.nextInt();
                if(max < zip[i][j]){
                    max = zip[i][j];
                }
            }
        }
        //물높이에 따른 침수 안된곳 묶음 찾기 최대값 높이 max 만큼 반복
        for(int h = 0; h < max; h++) {
            flood = new boolean[n][n]; //높이 할때마다 판 갈아

            int count = 0; //침수지역 개수 카운팅
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if(!flood[x][y] && zip[x][y] > h){ // 침수되지 않았으면서 물높이보다 집이 높은 경우에 탐색 시작
                        flood[x][y] = true;
                        count++;
                        move(x,y,h);

                    }
                }
            }
            if(dry < count){ // 안전지역 최대값 갱신
                dry = count;
            }
        }
        //최대값 출력
        System.out.println(dry);
    }

    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};

    public static void move(int x, int y, int height){

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 ||  ny < 0 || nx >= n || ny >= n) continue;
            if(flood[nx][ny]) continue;
            //물높이에 잠기면
            if(zip[nx][ny] <= height) continue;
            flood[nx][ny] = true;
            move(nx,ny,height);

        }
    }
} //2350 ㅈㄴ 오래걸렸네 집중 진짜 못한다
