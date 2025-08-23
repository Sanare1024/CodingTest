package implementation;

import java.util.*;
import java.io.*;

public class Bk12100 {

    static int n, answer; // 보드크기
    static int[][] board; // 초기보드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);

        System.out.println(answer);
    }

    // 0은 빈칸
    // 위 아래 왼 오 밀어서
    // 최대 5번 해서 얻을 수 있는 가장 큰 값

    public static void backtracking(int count) {
        //탈출 조건
        // 최대 5번했을경우
        // 모든 경우의 수 돌려서 최종 정답 max치로 뽑기

        //or 필드에 같은 숫자가 없을 경우(같은 숫자 없으면 더 합쳐질게 없으니 할 필요 없어보임)
        // 이것도 하면 좋긴하겠는데 매번 돌릴때마다 전체 맵 조회 + 숫자 비교? 성능상 너무 구리지 않나
        if (count == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
            return;
        }
        // 반복

        // 보드 복사
        int[][] copyBrd = new int[n][n]; // 복사본

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyBrd[i][j] = board[i][j];
            }
        }

        // 방향 밀기
        for (int d = 0; d < 4; d++) {
            move(d);
            backtracking(count + 1);

            //돌고 나왔으면 맵 원상 복구
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = copyBrd[i][j];
                }
            }
        }
    }

    private static void move(int dir) {
        if (dir == 0) { //상 (위에 숫자부터 쓸면서 내려와서 같은거 있으면 합치기)
            for (int i = 0; i < n; i++) {
                int count = 0;
                int blockNum = 0; //제일 최근 숫자

                for (int j = 0; j < n; j++) {
                    if (board[j][i] != 0) { //숫자를 만나면
                        if (board[j][i] == blockNum) { // 제일 최근 숫자와 같으면 = 합치기
                            board[count - 1][i] = blockNum * 2; //합
                            blockNum = 0; // 연달아서 합치는거 없으니까 최근숫자 없어짐
                            board[j][i] = 0;
                        } else { // 다르면 = 밀기
                            blockNum = board[j][i]; // 손에 쥐어
                            board[j][i] = 0; // 밀어서 없애
                            board[count][i] = blockNum; // 밀어
                            count++;
                        }
                    }
                }
            }
        } else if (dir == 1) { // 하
            for (int i = 0; i < n; i++) {
                int count = n - 1;
                int blockNum = 0; //제일 최근 숫자

                for (int j = n - 1; j >= 0; j--) { //아래부터 위로
                    if (board[j][i] != 0) { //숫자를 만나면
                        if (board[j][i] == blockNum) { // 제일 최근 숫자와 같으면 = 합치기
                            board[count + 1][i] = blockNum * 2; //합
                            blockNum = 0; // 연달아서 합치는거 없으니까 최근숫자 없어짐
                            board[j][i] = 0;
                        } else { // 다르면 = 밀기
                            blockNum = board[j][i];
                            board[j][i] = 0;
                            board[count][i] = blockNum;
                            count--;
                        }
                    }
                }
            }


        } else if (dir == 2) { // 좌
            for (int i = 0; i < n; i++) {
                int count = 0;
                int blockNum = 0; //제일 최근 숫자

                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) { //숫자를 만나면
                        if (board[i][j] == blockNum) { // 제일 최근 숫자와 같으면 = 합치기
                            board[i][count - 1] = blockNum * 2; //합
                            blockNum = 0; // 연달아서 합치는거 없으니까 최근숫자 없어짐
                            board[i][j] = 0;
                        } else { // 다르면 = 밀기
                            blockNum = board[i][j];
                            board[i][j] = 0;
                            board[i][count] = blockNum;
                            count++;
                        }
                    }
                }
            }

        } else { //우
            for (int i = 0; i < n; i++) {
                int count = n - 1;
                int blockNum = 0; //제일 최근 숫자

                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != 0) { //숫자를 만나면
                        if (board[i][j] == blockNum) { // 제일 최근 숫자와 같으면 = 합치기
                            board[i][count + 1] = blockNum * 2; //합
                            blockNum = 0; // 연달아서 합치는거 없으니까 최근숫자 없어짐
                            board[i][j] = 0;
                        } else { // 다르면 = 밀기
                            blockNum = board[i][j];
                            board[i][j] = 0;
                            board[i][count] = blockNum;
                            count--;
                        }
                    }
                }
            }
        }
    }
}
