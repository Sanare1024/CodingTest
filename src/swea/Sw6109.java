package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw6109 {

    static int n;
    static int[][] map;
    static int[][] copymap;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();

            map = new int[n][n];
            copymap = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (temp.equals("left")) {
                doLeft();
            } else if (temp.equals("right")) {
                doRight();
            } else if (temp.equals("up")) {
                doUp();
            } else if (temp.equals("down")) {
                doDown();
            }

            System.out.println("#" + t);
            print();
            System.out.print(sb);
        }
    }

    private static void doLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == 0) continue; // 0이 아닌 것을 찾기(기준점)
                int nextNum = j + 1; // 기준점 오른쪽에 0이 아닌 숫자 찾아보기

                while (map[i][nextNum] == 0 && nextNum < n - 1) { // 0이아닐때까지 & 범위 안 벗어나는 곳 까지
                    nextNum++;
                }
                if (map[i][j] == map[i][nextNum]) { // 쭉 미끄러져서 붙었는데 같은 글자이면?
                    map[i][j] = map[i][j] * 2; //합쳐지면 곱2
                    map[i][nextNum] = 0; //흡수되어서 삭제
                    j = nextNum; // j nextNum 까지 스킵
                }
            }
            //열 하나 끝 합치기 다했으니까 숫자 왼쪽으로 정렬하기
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    copymap[i][num] = map[i][j];
                    num++;
                }
            }
        }
    }

    private static void doRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--){ //left랑 반대
                if (map[i][j] == 0) continue; // 0 아닌거 찾
                int nextNum = j - 1; // 기준점의 왼쪽

                while (map[i][nextNum] == 0 && nextNum > 0) { // 0이아닐때까지 && 범위 안쪽
                    nextNum--;
                }

                if (map[i][j] == map[i][nextNum]) { // 같은 글자
                    map[i][j] = map[i][j] * 2; //곱2
                    map[i][nextNum] = 0; //흡수
                    j = nextNum; //  스킵
                }
            }
            //열 하나 끝 오른쪽 정렬
            int num = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    copymap[i][num] = map[i][j];
                    num--;
                }
            }
        }
    }

    private static void doUp() {
        for (int j = 0; j < n; j++){
            for (int i = 0; i < n - 1; i++){ //행 먼저
                if (map[i][j] == 0) continue;
                int nextNum = i + 1; // 기준점 아래

                while(map[nextNum][j] == 0 && nextNum < n - 1){
                    nextNum++;
                }

                if (map[i][j] == map[nextNum][j]) { // 같은 글자
                    map[i][j] = map[i][j] * 2; //곱2
                    map[nextNum][j] = 0; //흡수
                    i = nextNum; //  스킵
                }
            }
            //열 끝 위 정렬
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 0) {
                    copymap[num][j] = map[i][j];
                    num++;
                }
            }
        }
    }

    private static void doDown() {
        for (int j = 0; j < n; j++){
            for (int i = n - 1; i > 0; i--){ //행 아래 먼저
                if (map[i][j] == 0) continue;
                int nextNum = i - 1; // 기준점 위

                while(map[nextNum][j] == 0 && nextNum > 0){
                    nextNum--;
                }

                if (map[i][j] == map[nextNum][j]) { // 같은 글자
                    map[i][j] = map[i][j] * 2; //곱2
                    map[nextNum][j] = 0; //흡수
                    i = nextNum; //  스킵
                }
            }
            //열 끝 위 정렬
            int num = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    copymap[num][j] = map[i][j];
                    num--;
                }
            }
        }

    }

    private static void print() {
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(copymap[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}
