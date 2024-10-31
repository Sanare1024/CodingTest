package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk13460 { // 구슬 탈출2 - 아마 bfs

    static int n, m, minMove;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minMove = Integer.MAX_VALUE;

        map = new char[n][m];
        visited = new boolean[n][m][n][m]; // 빨간공 파란공 둘다 위치 체크해야해서

        int redBall_X = 0;
        int redBall_Y = 0;
        int blueBall_X = 0;
        int blueBall_Y = 0;

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == 'R'){
                    redBall_X = i;
                    redBall_Y = j;
                } else if (map[i][j] == 'B'){
                    blueBall_X = i;
                    blueBall_Y = j;
                }
            }
        }

        rolling(redBall_X, redBall_Y, blueBall_X, blueBall_Y, 0);

        if (minMove == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(minMove);
        }
    }

    // 입력조건
    //'.', '#', 'O', 'R', 'B'
    // . : 빈칸, # : 벽, O : 구멍, R : 빨간구슬, B : 파란구슬 제일 가장자리는 전부 벽
    // 빈칸0 벽1 구멍2 빨간구슬5 파란구슬9
    // 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개

    // 클리어조건
    // 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패,  빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
    // 1번 기울이면 구슬이 끝까지 이동할때까지 이동해야 끝남
    // 구슬끼리 못 겹침
    //  10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력

    // 이동순서
    // [1] 기울인다 (방향 4개 반복)
    // [2]. 빨간공 파랑공 한쪽방향으로 움직임(벽을 만날때까지)
    //      2-1. 움직이는 와중에 구멍 O 를만나면 멈춰
    //      2-2. 순서상관없이 파랑공이 빠졌다? 그 케이스 버림
    //      2-3. 파랑공 안빠지고 빨간공만 빠졌다? minMove 최소값 갱신
    // [3]. 움직임이 끝났을때 파랑공과 빨간공이 겹쳐있다? -> 이동한 거리 체크해서 더 많이 이동한 친구가 이동한 반대 방향으로 1칸 이동
    // [4]. 움직임이 끝났을때 visited 확인해서 둘다 한번이라도 왔던 자리면 스킵
    // [5]. 다 체크했으면 visited 트루하고 큐에 다시 넣기

    public static void rolling(int red_X, int red_Y, int blue_X, int blue_Y, int rollingCount){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {red_X, red_Y, blue_X, blue_Y, rollingCount});
        visited[red_X][red_Y][blue_X][blue_Y] = true;

        while(!q.isEmpty()){
            int[] nowInfo = q.poll(); // 정보 뽑
            int nowRollingCount = nowInfo[4];

            //탈출조건
            if (nowRollingCount >= 10){ // 10번 넘엇으면 끝내버리기
                return;
            }

            //반복내용
            for (int i = 0; i < 4; i++){  //[1] 기울인다 (방향 4개 반복)
                int nextR_X = nowInfo[0];
                int nextR_Y = nowInfo[1];
                int nextB_X = nowInfo[2];
                int nextB_Y = nowInfo[3];

                //[2]. 빨간공 파랑공 한쪽방향으로 움직임(벽을 만날때까지)
                //빨공
                while(map[nextR_X + dx[i]][nextR_Y + dy[i]] != '#'){ // 벽만날떄까지
                    nextR_X = nextR_X + dx[i];
                    nextR_Y = nextR_Y + dy[i];

                    if (map[nextR_X][nextR_Y] == 'O') break; // 2-1. 움직이는 와중에 구멍 O 를만나면 멈춰
                }
                //파공
                while(map[nextB_X + dx[i]][nextB_Y + dy[i]] != '#'){ // 벽만날떄까지
                    nextB_X = nextB_X + dx[i];
                    nextB_Y = nextB_Y + dy[i];

                    if (map[nextB_X][nextB_Y] == 'O') break; // 2-1. 움직이는 와중에 구멍 O 를만나면 멈춰
                }

                //2-2. 순서상관없이 파랑공이 빠졌다? 그 케이스 버림
                if (map[nextB_X][nextB_Y] == 'O') continue;

                //2-3. 파랑공 안빠지고 빨간공만 빠졌다? minMove 최소값 갱신
                if (map[nextR_X][nextR_Y] == 'O'){
                    minMove = Math.min(minMove, nowRollingCount + 1); // 지금 롤링 개수+1 개로 갱신
                    return;
                }

                //[3]. 움직임이 끝났을때 파랑공과 빨간공이 겹쳐있다? -> 이동한 거리 체크해서 더 많이 이동한 친구가 이동한 반대 방향으로 1칸 이동
                if (nextR_X == nextB_X && nextR_Y == nextB_Y) {
                    int redDistance = Math.abs(nextR_X - nowInfo[0]) + Math.abs(nextR_Y - nowInfo[1]);
                    int blueDistance = Math.abs(nextB_X - nowInfo[2]) + Math.abs(nextB_Y - nowInfo[3]);

                    if (redDistance > blueDistance){ // 빨강이 더 이동했다?
                        nextR_X = nextR_X - dx[i];
                        nextR_Y = nextR_Y - dy[i]; // 왔던방향 한칸전으로 돌림

                        //(공이 겹칠수 없다는 조건이 있기때문에 이동거리가 같을 수는 없음)
                    } else { // 파랑이 더 이동했다
                        nextB_X = nextB_X - dx[i];
                        nextB_Y = nextB_Y - dy[i];
                    }
                }

                //[4]. 움직임이 끝났을때 visited 확인해서 둘다 한번이라도 왔던 자리면 스킵
                if (visited[nextR_X][nextR_Y][nextB_X][nextB_Y]) continue;

                //[5]. 다 체크했으면 visited 트루하고 큐에 다시 넣기
                visited[nextR_X][nextR_Y][nextB_X][nextB_Y] = true;

                q.add(new int[] {nextR_X, nextR_Y, nextB_X, nextB_Y, nowRollingCount + 1});
            }
        }
    }
}
