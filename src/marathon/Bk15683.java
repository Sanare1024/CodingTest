package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk15683 { //감시 - 조합

    static int n, m, blindSpot;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};  //위 오른 아래 왼
    static ArrayList<CCTV> cctvList;

    static class CCTV {
        int x, y, num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException { //2117
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        blindSpot = Integer.MAX_VALUE; //최소값 넣는곳
        cctvList = new ArrayList<>();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > 0 && map[i][j] < 6) { //cctv모으기
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        //백트래킹 조합 조지는곳
        Observing(0, map);
        //결과 확인 + 출력
        System.out.println(blindSpot);


    }
    // 0은 빈칸 6이 벽
    // cctv_1 = 한방향 ->    / 4종류
    // cctv_2 = 양방향 ㅡ    / 2종류
    // cctv_3 = 직각방향 ㄴ  / 4종류
    // cctv_4 = 세방향 ㅗ    / 4종류
    // cctv_5 = 전방향 +    / 1종류
    // 벽막히면 뒤에는 못봄 / cctv끼리는 통과 가능 / 맵을 보고 사각지대(cctv가 못보는곳)의 최소크기를 구하시오
    //조합, 순서 상관없음
    // cctv별로 방향에 따른 종류 다 만들기 vs 보는방향 정해놓고 4번 돌리기
    // 어짜피 n, m 크기않고 (1 ≤ N, M ≤ 8),  cctv도 최대 8개니까 시간제한 1초. 후자로 해도될듯
    static int[][] cctvDirection = { //cctv가 보는방향  [cctv번호][방향]
            {},// 빈칸
            {0}, //1번
            {0, 2}, //2번
            {0, 1}, //3번
            {0, 1, 2}, //4번
            {0, 1, 2, 3}, //5번
    };

    public static void Observing(int cctvCount, int[][] copyMap) { // cctv하나 할떄마다 맵 들고다녀야함
        //탈출조건
        if(cctvCount == cctvList.size()){ //다뽑으면 탈출
            //빈칸 확인
            int tmpBlindArea = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (copyMap[i][j] == 0){
                        tmpBlindArea++;
                    }
                }
            }
            //최소값 갱신
            blindSpot = Math.min(blindSpot, tmpBlindArea);
            return;
        }

        //반복
        // cctvCount번째 cctv꺼내와서 정보 확인하고 4방향으로 돌려가면서 배치해보고 맵 색칠 후 다음으로 반복

        int cctvX = cctvList.get(cctvCount).x;
        int cctvY = cctvList.get(cctvCount).y;
        int cctvNum = cctvList.get(cctvCount).num;

        for (int i = 0; i < 4; i++){ // 4번 돌리버리기
            int[][] nowCopyMap = copyMap(copyMap); //현재 맵 저장 및 복사

            for(int direction : cctvDirection[cctvNum]){
                int nDir = (direction + i) % 4; // 보는 방향 정하기
                int nx = cctvX;
                int ny = cctvY; //일단 지금위치

                while (true) { //nDir 방향으로 벽 만날때까지 cctv 빛 비추기
                    nx = nx + dx[nDir];
                    ny = ny + dy[nDir];

                    //받은 맵에서 이동할 방향에 벽이나 맵밖으로 나갈때 까지 반복, 만나면 브레이크
                    //cctv 만나면 어짜피 통과 가능하고 cctv위치 리스트 가지고있으니까 지워버려도됨
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || copyMap[nx][ny] == 6) break;
                    nowCopyMap[nx][ny] = -1; // 지나간곳을 -1로 표시
                }
            }
            // 빛 다 비췄으면 다음 cctv로 진행
            Observing(cctvCount + 1, nowCopyMap);
            //나오면 for문 돌면서 다른방향 확인됨
        }
    }

    public static int[][] copyMap(int[][] map){ //받은 맵 깊은 복사
        int[][] copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }
}
