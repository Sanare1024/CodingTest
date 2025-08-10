package greedy;

import java.util.*;
import java.io.*;

public class Bk11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            // k원 보다 작게 or 같게 합치면서 빼나가면 최소값
            if (coins[i] <= k) { // 동전이 k보다 작으면
                count += (k / coins[i]); // 그 동전을 k/동전 개수 만큼 추가
                k = k % coins[i]; // 넣은만큼 빼고 나머지 돈으로 k 변경
            }
        }

        System.out.println(count);
    }
}
