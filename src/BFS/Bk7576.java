package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bk7576 {

    static int m;
    static int n;
    static int[][] box;
    static Queue<tomato> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        box = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    queue.add(new tomato(i, j ,0));
                }
            }
        }


        diffusion();
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public  static void diffusion() {
        int day = 0;

        while (!queue.isEmpty()){
            tomato nowTomato = queue.poll();//now토마토는 큐에서 뽑은거
            day = nowTomato.day;  //날짜

            //탈출 조건 : 전부 다 전염되면 = 큐 빌 떄까지 돌리기
            //할 일 : -1:토마토가 없는 칸(노터치), 0:안익은 토마토, 1:익은토마토
            // 1주변의 0은 하루마다
            for(int i = 0; i < 4; i++){
                int nx = nowTomato.x + dx[i];
                int ny = nowTomato.y + dy[i];

                if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;// 나가기 방지
                if(box[nx][ny] == 0){//상하좌우 에 0이 있으면
                    box[nx][ny] = 1; //전염
                    queue.add(new tomato(nx,ny,day + 1)); //큐에다가 넣어
                }
            }
        }
        //큐 다돌았음 이때 박스에 0이 남아있을 수도 있음(막혀서 감염이 안되었을 경우)
        //만약 전체에 0이 남아있으면 출력 -1  0이 없으면 day 출력

        boolean check = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0) {
                    check = false;
                }
            }
        }

        if(check){
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }



    static class tomato { //도마도
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;

        }
    }

}
