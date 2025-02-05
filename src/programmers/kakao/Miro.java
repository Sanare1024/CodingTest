package programmers.kakao;

public class Miro {
    public static int N, M, R, C, K;
    public static int[] dy = {1, 0, 0, -1};
    public static int[] dx = {0, -1, 1, 0};
    public static String[] move = {"d", "l", "r", "u"}; // 사전적으로 d -> l -> r -> u 순으로 탐색
    public static String text = "z";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r - 1;
        C = c - 1;
        K = k;

        // 도착까지 거리보다 K가 작거나, 최소 이동횟수를 제외한 나머지 횟수가 홀수면 불가능
        if (distance(y - 1, x - 1) > K || (K - distance(y - 1, x - 1)) % 2 == 1) {
            return "impossible";
        }
        find(x - 1, y - 1, 0, "");
        return text;
    }

    public static void find(int a, int b, int d, String s) {
        // 현재 위치에서 목표까지 거리보다 짧거나 결과 값보다 사전적으로 뒤처지면 돌아가기
        if (d + distance(a, b) > K || s.compareTo(text) > 0) {
            return;
        }

        // K를 다썼는데 E에 도착했다면 저장
        if (d == K && a == R && b == C) {
            text = s;
            return;
        }

        // 범위 값에서 벗어나지 않게 백트래킹 구성
        for (int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];
            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                find(ny, nx, d + 1, s + move[i]);
            }
        }
    }

    public static int distance(int y, int x) { // 현재 위치와 목표까지 거리
        return Math.abs(R - y) + Math.abs(C - x);
    }
}
