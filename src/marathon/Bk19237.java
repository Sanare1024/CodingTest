package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk19237 {
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1}; //위 아래 왼쪽 오른쪽 0번은 안쓰는곳

    static class Shark { //상어
        int x, y, dir;

        public Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static class Smell { // 냄새
        int sharkNum, time;

        public Smell(int sharkNum, int time) {
            this.sharkNum = sharkNum;
            this.time = time;
        }
    }

    static int n, m, k, totalTime;
    static int[][] sea; //바다 맵
    static Smell[][] smellMap; //냄새 맵
    static Shark[] sharkList; // 상어배열
    static int[][][] sharkPriorityDir; //상어 방향 우선순위 배열

    public static void main(String[] args) throws IOException { //50분 + 40분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 격자 크기
        m = Integer.parseInt(st.nextToken()); // 상어 마리 수
        k = Integer.parseInt(st.nextToken()); // 냄새가 제거되는데 필요한 초

        sea = new int[n][n];
        smellMap = new Smell[n][n];
        sharkList = new Shark[m + 1]; // 1번부터 채우기
        sharkPriorityDir = new int[m + 1][5][5]; // 대가리 우선방향 배열 [상어번호][대가리방향][우선순위순서]

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());

                if (sea[i][j] != 0) {
                    sharkList[sea[i][j]] = new Shark(i, j, 0); // 상어 넣기
                    smellMap[i][j] = new Smell(sea[i][j], k); //냄새도 넣기 (상어번호, 시간)
                }
            }
        }
        //상어 시작 머리 방향
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            sharkList[i].dir = Integer.parseInt(st.nextToken());
        }

        //상어 머리 우선방향 배열
        for (int i = 1; i <= m; i++) {  //m번 반복
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 4; k++) {
                    sharkPriorityDir[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        totalTime = 0;
        while (totalTime <= 1000) { //1000초까지 돌리기 1번말고 다른거 남아있으면 -1출력
            //탈출조건 - 1번 상어만 상자에 남았나? (탈출할때 시간 확인)
            if (Shark01_Alone()) {
                break;
            }

            //반복내용
            totalTime++; //시간 증가
            SwimShark(); //헤엄헤엄
            Diffusing(); //냄시냄시
        }

        if (totalTime > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(totalTime);
        }
    }

    //상어 움직임
    // [1] 움직일 방향 정하기
    //이동 조건
    // 1. 냄새가 없는 인접한곳 (가능한 곳이 여러개면 우선 순위에 따라 방향 변경)
    // 2. 위가 안되면 자기 냄새가 있는곳 (이것도 여러개면 우선순위)
    // 아예 찾을때 부터 우선순위로 찾게 하면 쉬워질듯

    // [2] 이동(+ 머가리 방향 변경)
    // [3] 겹치면 작은번호 빼고 사라지기
    // [4] 냄새 뿌리기

    public static void SwimShark() {
        for (int sNum = 1; sNum <= m; sNum++) {  // 상어 마리수 만큼 반복하지만
            //죽은 상어 있으면 패스
            if (sharkList[sNum] == null) continue;

            Shark nowShark = sharkList[sNum];
            int sharkHead = nowShark.dir; // 지금 대가리
            boolean possibleNoSmell = false; // 가능?
            //상어 움직임 [1]
            //이동조건 1. 냄새 없는곳
            for (int i = 1; i <= 4; i++) {
                int pDirection = sharkPriorityDir[sNum][sharkHead][i]; // sNum 번의 상어의 지금 대가리 방향일때 우선순위중 i번째
                int nx = nowShark.x + dx[pDirection];
                int ny = nowShark.y + dy[pDirection];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; //범위 나가면 패스
                if (smellMap[nx][ny] == null) { //냄새 없으면 방향전환
                    sharkHead = pDirection; //머리돌려
                    possibleNoSmell = true;
                    break;
                }
            }
            // 1번 조건 안될시 -> 2번 자기 냄새 찾기
            if (!possibleNoSmell) {
                for (int i = 1; i <= 4; i++) {
                    int pDirection = sharkPriorityDir[sNum][sharkHead][i]; //sNum 번의 상어의 지금 대가리 방향일때 우선순위중 i번째
                    int nx = nowShark.x + dx[pDirection];
                    int ny = nowShark.y + dy[pDirection];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; //범위 나가면 패스
                    if (smellMap[nx][ny].sharkNum == sNum) { // 냄새맵의 상어 번호가 내 번호랑 같으면 방향전환
                        sharkHead = pDirection; //머리돌려
                        break;
                    }
                }
            }

            //[2] 이동하기
            int nx = nowShark.x + dx[sharkHead];
            int ny = nowShark.y + dy[sharkHead]; //머리방향으로 이동
            nowShark.dir = sharkHead; // 돌린 머리 넣어

            if (sea[nx][ny] == 0) { // 앞이 물이면
                sea[nx][ny] = sNum; // nx,ny로 이동
                sea[nowShark.x][nowShark.y] = 0; //뒤에 물로 변경

                sharkList[sNum].x = nx;
                sharkList[sNum].y = ny;  // 배열 이동한거 넣기

                //[3] 겹치면 작은번호 빼고 사라지기
            } else if (sea[nx][ny] > sNum) { // 앞에 나보다 번호가 큰 상어가 있으면
                int dieShark = sea[nx][ny];
                sharkList[dieShark] = null; //으앙 주금

                sea[nx][ny] = sNum; // 작은번호 nx ny로 이동
                sea[nowShark.x][nowShark.y] = 0; //뒤에 물로 변경

                sharkList[sNum].x = nx;
                sharkList[sNum].y = ny;  // 배열 이동한거 넣기
            } else { // 큰번호가 이동해서 만난경우
                sharkList[sNum] = null; // 큰번호 주금
                sea[nowShark.x][nowShark.y] = 0; // 뒤에 물로 변경
            }
        }
        // 상어마리 수 만큼 이동 완료
    }

    public static void Diffusing() {
        // [4] 냄새 뿌리기
        // 전체 맵 냄새 턴줄이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (smellMap[i][j] == null) continue;

                if (smellMap[i][j].time == 1) {
                    smellMap[i][j] = null;
                } else {
                    smellMap[i][j].time -= 1;
                }
            }
        }
        // 이동한 상어 냄새 남기기
        for (int sNum = 1; sNum <= m; sNum++) {
            if (sharkList[sNum] != null) { // 안죽었으면 냄새 남겨
                smellMap[sharkList[sNum].x][sharkList[sNum].y] = new Smell(sNum, k);
            }
        }
    }

    public static boolean Shark01_Alone() {
        for (int i = 2; i <= m; i++) {
            if (sharkList[i] != null) { // 살아있으면
                return false;
            }
        }
        //다돌고 나왔으면 1빼고 다죽음
        return true;
    }
}
