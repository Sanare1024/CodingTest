package dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk17825 {
    static int ans;
    static int[] token;
    static int[] dice;
    static int[] map = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //1번루트(0-21)
            10, 13, 16, 19, 25, 30, 35, 40, 0,  //2번 지름길 루트(22-30)
            20, 22, 24, 25, 30, 35, 40, 0,      //3번 지름길 루트(31-38)
            30, 28, 27, 26, 25, 30, 35, 40, 0}; //4번 지름길 루트(39-47)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[10]; // 주사위 순서
        token = new int[10]; // 말 순서

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int count) { // 조합짜기
        if (count == 10) {
            moveToken();
            return;
        }

        for (int i = 0; i < 4; i++) {
            token[count] = i;
            dfs(count + 1);
        }
    }

    public static void moveToken() { //말 이동
        boolean[] visited = new boolean[map.length];
        int score = 0;
        int[] p = new int[4];

        for(int i=0 ; i<10 ; i++) {
            int nowDice = dice[i];
            int nowToken = token[i];
            if(isFinish(p[nowToken])) return;

            int next = nextPoint(p[nowToken], nowDice);
            if(isFinish(next)) { //
                setVisited(visited, p[nowToken], false);
                p[nowToken] = next;
                continue;
            }
            if(visited[next]) return;
            setVisited(visited, p[nowToken], false);
            setVisited(visited, next, true);

            p[nowToken] = next;
            score += map[p[nowToken]];
        }
        ans = Math.max(ans, score);
    }


    public static void setVisited(boolean[] visited, int idx, boolean check) {
        if(idx == 20 || idx == 29 || idx == 37 || idx == 46) { // 40
            visited[20] = check;
            visited[29] = check;
            visited[37] = check;
            visited[46] = check;
        } else if(idx == 26 || idx == 34 || idx == 43) { // 25
            visited[26] = check;
            visited[34] = check;
            visited[43] = check;
        } else if(idx == 27 || idx == 35 || idx == 44) { // 30
            visited[27] = check;
            visited[35] = check;
            visited[44] = check;
        }else if(idx == 28 || idx == 36 || idx == 45) { //35
            visited[28] = check;
            visited[36] = check;
            visited[45] = check;
        }else {
            visited[idx] = check;
        }
    }

    public static int nextPoint(int nowIdx, int dice) { // 다음 주사위 위치 확인
        int nextIdx = nowIdx + dice; // 지금위치 + 주사위

        if(nowIdx < 21) { //현위치 1 번투르 안쪽
            if(nextIdx >= 21) nextIdx = 21; // 1번루트인데 인댁스가 넘어간거면 끝까지 간거니까 0으로 바꿔줌
        } else if(nowIdx < 30) { // 2번
            if(nextIdx >= 30) nextIdx = 30; // 2..
        } else if(nowIdx < 38) { // 3번
            if(nextIdx >= 38) nextIdx = 38; // 3..
        } else if(nowIdx < 47) { // 4번
            if(nextIdx >= 47) nextIdx = 47; // 4..
        }
        //1번 루트 가다가 중간에 파란 발판 밟았으면 해당 루트로 인댁스 바꿔줌
        if(nextIdx == 5) return 22;
        if(nextIdx == 10) return 31;
        if(nextIdx == 15) return 39;
        return nextIdx;
    }

    public static boolean isFinish(int idx) {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47; // 0 에 도착했으면 끝
    }
}
