package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bk2667 {

    static int n; //지도 가로세로
    static int[][] zip; //집
    static boolean[][] visited; //체크
    static int danzi; //단지 집수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dab = new ArrayList<>(); //답 어레이리스트

        //받
        n = Integer.parseInt(br.readLine());
        zip = new int[n][n];
        visited = new boolean[n][n];

        //집넣
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < n; j++){
                zip[i][j] = temp.charAt(j)-'0';
            }
        }

        //단지 묶기
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++){
                if(!visited[x][y] && zip[x][y] == 1){ //안가본곳이면서 집있으면 실행
                    visited[x][y] = true; //입장집 체크
                    danzi = 1; //처음 집 카운팅/ 밑에 넣으면 안되니까 여기

                    move(x,y);
                    dab.add(danzi);// 개수 다 샌 단지 list에 넣기

                }
            }
        }

        //일단 정렬 복사
        dab.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        //한줄씩 집개수 출력
        System.out.println(dab.size());
        for(int i = 0; i < dab.size(); i++){
            System.out.println(dab.get(i)); //특정 인데스 추출 arr[]
        }


    }

    static int[] dx = {0,0,-1,1}; //상하 좌우
    static int[] dy = {-1,1,0,0};

    public static void move(int x, int y) {


        for (int i = 0; i < 4; i++) {//상하좌우 위로간 좌표 밑으로간거 옆 오른쪽

            int nx = x + dx[i];
            int ny = y + dy[i];

            //나가는거 방지
            if(nx < 0 ||  ny < 0 || nx >= n || ny >= n) continue;
            // 갔던데
            if(visited[nx][ny]) continue;
            //홈리스
            if(zip[nx][ny] == 0) continue;
            visited[nx][ny] = true;
            danzi++;
            move(nx,ny);
        }
    }


}
