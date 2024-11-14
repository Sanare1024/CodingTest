package dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk17136 {

    static int[][] map = new int[10][10];
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void backTracking(int index, int count) {
        if (index == 100) { // 끝까지 다돌았으면 정답이랑 지금 개수랑 비교해서 최솟값
            ans = Math.min(count, ans);
            return;
        }

        int x = index / 10;
        int y = index % 10;

        if (map[x][y] == 1) {
            for (int pSize = 5; pSize > 0; pSize--) { //큰거부터 붙여봐
                if (paperCount[pSize] > 0 && possible(x, y, pSize)) { // 종이가 있고 붙이는 범위가 된다면?
                    //종이 붙이기
                    paperCount[pSize] -= 1;
                    for (int i = x; i < x + pSize; i++) {
                        for (int j = y; j < y + pSize; j++) {
                            map[i][j] = 0;
                        }
                    }
                    //붙였으니까 다음
                    backTracking(index + 1, count + 1);
                    // 리턴 안되고 나왔으면 다른 경우의 수봐야하니까 원상복귀
                    paperCount[pSize] += 1;
                    for (int i = x; i < x + pSize; i++) {
                        for (int j = y; j < y + pSize; j++) {
                            map[i][j] = 1;
                        }
                    }
                }
            }
        } else {
            backTracking(index + 1, count);
        }
    }

    public static boolean possible(int x, int y, int paperSize) {
        if (x + paperSize > 10 || y + paperSize > 10) { //map 범위 벗어나면 안됨
            return false;
        }
        //덮는 범위만큼 안에 1아닌거 있으면 패스
        for (int i = x; i < x + paperSize; i++) {
            for (int j = y; j < y + paperSize; j++) {
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }

}
