package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk17144 {

    static int r, c, t, airCleanerR;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        airCleanerR = -1;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1 && airCleanerR == -1) { //r위치 받기
                    airCleanerR = i; // (i,1)이 청정기 윗부분
                }
            }
        }

        map[airCleanerR][0] = 0;
        map[airCleanerR + 1][0] = 0;

        while (t > 0) {
            diffusion(); //미세먼지 퍼짐
            airCleanerOn(); //청정기 한바퀴
            t--;
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res += map[i][j]; //먼지 수거
            }
        }

        System.out.println(res);
    }

    static void diffusion() {
        ArrayList<Dust> dustList = new ArrayList<>();

        for (int i = 0; i < r; i++) { //먼지 체크
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 5) { //5이상만 확산
                    dustList.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        for (Dust dust : dustList) { //확산
            int countArea = 0;

            int x = dust.x;
            int y = dust.y;
            int v = dust.value;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue; //나가면 스킵
                if (nx == airCleanerR && ny == 0) continue; //청정기 위에 스킵
                if (nx == airCleanerR + 1 && ny == 0) continue; //청정기 아래 스킵

                map[nx][ny] += v / 5; //나눠주고
                countArea++; //나눠준칸 카운트
            }

            map[x][y] -= v / 5 * countArea; //나눠준 만큼 빼기
        }
    }

    static void airCleanerOn() {
        //청정기 윗부분
        for (int i = airCleanerR - 1; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        map[airCleanerR][0] = 0; //윗부분에 들어간건 정화
        for (int i = 1; i < c; i++) {
            map[0][i - 1] = map[0][i];
        }
        for (int i = 1; i <= airCleanerR; i++) {
            map[i - 1][c - 1] = map[i][c - 1];
        }
        for (int i = c - 2; i >= 0; i--) {
            map[airCleanerR][i + 1] = map[airCleanerR][i];
        }


        //아랫부분
        for (int i = airCleanerR + 2; i <= r - 1; i++) {
            map[i - 1][0] = map[i][0];
        }
        map[airCleanerR + 1][0] = 0; //아랫부분에 들어간건 정화
        for (int i = 1; i < c; i++) {
            map[r - 1][i - 1] = map[r - 1][i];
        }
        for (int i = r - 2; i >= airCleanerR + 1; i--){
            map[i + 1][c - 1] = map[i][c - 1];
        }
        for (int i = c - 2; i >= 0; i--){
            map[airCleanerR + 1][i + 1] = map[airCleanerR + 1][i];
        }

    }

    static class Dust {
        int x;
        int y;
        int value;

        public Dust(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
