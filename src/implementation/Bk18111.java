package implementation;

import java.util.*;
import java.io.*;

public class Bk18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int min = 256;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) min = map[i][j];
                if (max < map[i][j]) max = map[i][j];
            }
        }

        //time은 최소시간을 저장 할 변수
        int time = 99999999;
        int high = 0;

        //만틀 층 i
        for (int i = min; i <= max; i++) {
            int count = 0;
            int block = b;
            //좌표 j와 k
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    //현재 좌표의 층이 만들 층보다 높으면 제거하는데, 블록은 제거한 만큼 추가, 시간은 두배로
                    if (i < map[j][k]) {
                        count += ((map[j][k] - i) * 2);
                        block += (map[j][k] - i);
                        //낮을 경우 블록은 제거, 시간은 1배
                    } else {
                        count += (i - map[j][k]);
                        block -= (i - map[j][k]);
                    }
                }
            }
            //블록의 개수가 음수가 되면 반복문 종료
            if (block < 0) break;

            if (time >= count) {
                time = count;
                high = i;
            }
        }

        System.out.println(time + " " + high);
    }
}
