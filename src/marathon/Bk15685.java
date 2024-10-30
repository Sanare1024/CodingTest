package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk15685 {


    static int[][] map;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1}; //우상좌하 -> 이것도 반대로 생각해야되네;;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[101][101]; //0~100까지 101개

        for (int i = 0; i < n; i++) { //n개 드래곤커브 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());  //배열 반대로 생각해야함
            int dir = Integer.parseInt(st.nextToken()); // 방향
            int g = Integer.parseInt(st.nextToken()); // 세대 -> 그릴때 반복횟수

            drowCurve(x, y, dir, g);
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) { //0 ~ 100
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void drowCurve(int x, int y, int dir, int g) {
        //x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대
        //(0 ≤ x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
        //그리는 과정
        //선개수 = 1 -> 2 -> 4 -> 8 2배씩 (원래 있던선 시계방향으로 90도 돌리기 = 그려온 dir방향을 역순으로 +1) -> 하면서 리스트 넣으면 2배
        //세대 g 만큼 반복
        ArrayList<Integer> dirList = new ArrayList<>();
        dirList.add(dir); //처음 방향 넣기

        for (int i = 0; i < g; i++) { //세대만큼 반복
            for (int j = dirList.size(); j > 0; j--) { //리스트 사이즈만큼 반복
                dirList.add((dirList.get(j - 1) + 1) % 4); //역순으로 꺼내와서 방향 +1 해주기
            }
        }
        //방향 다 넣었으니 방향때로 따라서 점이동하며 선그리기
        map[y][x] = 1; //xy 반대로 생각

        for (int i = 0; i < dirList.size(); i++) {
            y = y + dy[dirList.get(i)];
            x = x + dx[dirList.get(i)];

            map[y][x] = 1;
        }
    }

}
