package dp;

import java.util.*;
import java.io.*;

public class Bk2342 {
    static int[][] cost = {
            {1, 2, 2, 2, 2},
            {1, 1, 3, 4, 3},
            {1, 3, 1, 3, 4},
            {1, 4, 3, 1, 3},
            {1, 3, 4, 3, 1}
    };
    static int[][][] dp;
    static int[] ddr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ddr = new int[st.countTokens()];

        for (int i = 0; i < ddr.length; i++) {
            ddr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[ddr.length][5][5];

        System.out.println(ddrPlay(0, 0, 0));


    }

    //depth = 다음 발판을 (왼발로 밟는 경우의 비용 + 그 경우의 수까지의 최소 비용) vs (오른발로 밟는 경우의 비용 + 그 경우의 수까지의 최소 비용)
    private static int ddrPlay(int depth, int left, int right) {
        if (depth == ddr.length - 1)
            return 0;

        if (dp[depth][left][right] != 0) return dp[depth][left][right];

        int next = ddr[depth];

        if (next == left || next == right) {
            dp[depth][left][right] = ddrPlay(depth + 1, left, right) + 1;
        } else {
            dp[depth][left][right] = Math.min(ddrPlay(depth + 1, Math.min(next, right), Math.max(next, right)) + cost[left][next],
                    ddrPlay(depth + 1, Math.min(left, next), Math.max(left, next)) + cost[right][next]);
        }

        return dp[depth][left][right];
    }
}
