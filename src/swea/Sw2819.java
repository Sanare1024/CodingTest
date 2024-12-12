package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw2819 {

    static int count;
    static String[][] map;
    static boolean[] checkNum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            count = 0;
            map = new String[4][4];
            checkNum = new boolean[10000000]; //7글자 다들어가는 배열

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++) {
                    String tmp = "";
                    dfs(0, i, j, tmp);
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }

    //6번 이동으로 7자리 숫자 만들기
    // 조건 - 시작이 0이여도됨(0102001), 한번 거쳤던 격자칸 다시 거쳐도됨, 벗어나는것만 안됨
    private static void dfs(int index, int x, int y, String num) {
        //탈출조건
        if (index == 7) {
            int number = Integer.parseInt(num); // int로 변환 (앞에 0때기)

            if (!checkNum[number]) { // 중복아니면 체크
                checkNum[number] = true;
                count++;
            }

            return;
        }
        //반복
        num = num + map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;

            dfs(index + 1, nx, ny, num);
        }
    }
}
