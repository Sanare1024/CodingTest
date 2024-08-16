package DFS;

import java.util.Scanner;

public class Bk1182 {
    static int[] num;
    static int n;
    static int s; // 정수의 합
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        dfs(0, 0);
        if (s == 0) {
            System.out.println(answer - 1);
        }
        else  System.out.println(answer);

    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) answer++;
            return;
        }
        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);
    }
}
