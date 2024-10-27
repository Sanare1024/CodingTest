package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw1767 {
    //1. 7 ≤  N ≤ 12
    //2. Core의 개수는 최소 1개 이상 12개 이하이다.
    //3. 최대한 많은 Core에 전원을 연결해도, 전원이 연결되지 않는 Core가 존재할 수 있다.
    static int n;
    static int[][] map;
    static ArrayList<Node> coreList;
    static int minRail, maxCore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            StringTokenizer st;
            coreList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) { // 길이 뻗어야하는 코어 리스트에 넣기
                        if (i == 0 || i == n - 1 || j == 0 || j == n - 1) continue; //벽에 붙은건 패스
                        coreList.add(new Node(i, j));
                    }
                }
            }

            minRail = Integer.MAX_VALUE; // 최소 전선 넣을곳
            maxCore = Integer.MIN_VALUE; // 최대한 연결했을때 코어갯수 카운팅용

            buildRail(0, 0, 0);

            sb.append("#").append(t).append(" ").append(minRail).append("\n");
        }

        System.out.println(sb);
    }

    static void buildRail(int num, int connectedCore, int railnum) {
        //탈출조건 - num 이 코어 개수랑 같을때, 이때
        if (num == coreList.size()) { // 모든 코어 다 해봤을때
            if (maxCore < connectedCore) { // 연결된 코어가 최대코어 갱신하면 갱신하고 그게 최소가 되게
                maxCore = connectedCore;
                minRail = railnum;
            } else if (maxCore == connectedCore) { // 연결된 코어가 최대코어랑 같으면 최소값인지 갱신
                minRail = Math.min(minRail, railnum);
            }
            return;
        }
        //반복
        //    - 1.한방향 끝까지 갔는데
        //          1-1 전선 or 코어 만나면 break 하면서 length 초기화
        //          1-2 밖에 만나면 length 길이만큼 1깔기
        //    - 4방향 다했는데 하나도 안된다? num++ 나머진 그대로 다음 dfs

        for (int i = 0; i < 4; i++) {
            int x = coreList.get(num).x;
            int y = coreList.get(num).y;
            int length = 0; // 레일 뻗어가는 길이

            int nx = x;
            int ny = y;
            while (true) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                //1-2
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;//나가서 레일깔기
                }
                //1-1
                if (map[nx][ny] == 1) {
                    length = 0;
                    break;
                }
                //둘다 아니면 레일 길이 앞으로 한칸 더
                length++;
            }

            //while끝나고 length가 0이면 안되는선택지니까 num++ / 0아니면 레일 깔고 num,core,rail갱신
            if (length == 0) {
                buildRail(num + 1, connectedCore, railnum);
            } else {
                int buildX = x;
                int buildY = y;
                //레일 설치
                for (int j = 0; j < length; j++) {
                    buildX = buildX + dx[i];
                    buildY = buildY + dy[i];
                    map[buildX][buildY] = 1;
                }

                //설치 다했으면 다음 dfs
                buildRail(num + 1, connectedCore + 1, railnum + length);

                //dfs돌고 나왔으면 깔았던 레일 철거
                buildX = x;
                buildY = y;
                //레일 설치
                for (int j = 0; j < length; j++) {
                    buildX = buildX + dx[i];
                    buildY = buildY + dy[i];
                    map[buildX][buildY] = 0;
                }
            }
        }
    }

    static int dx[] = {-1, 0, 1, 0}; //상우하좌
    static int dy[] = {0, 1, 0, -1};


    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
