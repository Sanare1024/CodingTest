package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk2096 {

    static int n, maxAns, minAns;
    static int[][] map;
    static int[][] max;
    static int[][] min;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        max = new int[n][3];
        min = new int[n][3];
        maxAns = Integer.MIN_VALUE;
        minAns = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //내려가면서 위에서 올수 있는것 중에 최소 최대 확인해서 배열에 저장 하면서 내려감
        //맨위 입력
        max[0][0] = map[0][0];
        max[0][1] = map[0][1];
        max[0][2] = map[0][2];

        min[0][0] = map[0][0];
        min[0][1] = map[0][1];
        min[0][2] = map[0][2];

        goingDown();

        System.out.println(maxAns + " " + minAns);
    }

    private static void goingDown() {
        //쭉내려가면서 윗줄에서 최대값, 최솟값 찾아서 저장하면서 내려가면 그것이 최대값 최소값 루트
        for (int i = 1; i < n; i++) {
            //최대값 배열
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0]; // 1번칸은 윗줄 1,2
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + map[i][1]; // 2번칸은 윗줄 1,2,3
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2]; // 3번칸은 윗줄 2,3

            //최소값 배열
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0]; // 상동
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + map[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];
        }

        for (int i = 0; i < 3; i++) {
            maxAns = Math.max(maxAns, max[n - 1][i]);
            minAns = Math.min(minAns, min[n - 1][i]);
        }

    }
}
