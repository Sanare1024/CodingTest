package programmers.kakao;
import java.util.*;

public class KeepDistance {

    public class Node{
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {-1, 1, 0 ,0};
    int[] dy = {0, 0, -1, 1};
    String[][] map;
    boolean[][] visited;

    public int[] solution(String[][] places) {
        //T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
        // 준수 하고있다 1 아니다 0
        int[] answer = new int[5];

        for (int tc = 0; tc < 5; tc++) {
            String[] copyMap = places[tc];
            Queue<Node> q = new LinkedList<>();

            map = new String[5][5];

            for(int i = 0; i < 5; i++) {
                String[] a = copyMap[i].split("");

                for(int j = 0 ; j < 5; j++){
                    map[i][j] = a[j];

                    if("P".equals(map[i][j])){
                        q.add(new Node(i,j));
                    }
                }
            }

            int flag = 1;

            while(!q.isEmpty()){
                Node now = q.poll();
                visited = new boolean[5][5];
                visited[now.x][now.y] = true;

                for(int i = 0; i < 4 ; i ++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                    if("X".equals(map[nx][ny])) continue; // 파티션이면 스킵

                    if("P".equals(map[nx][ny])) { //바로옆에 사람있으면 안됨
                        flag = 0;
                        break;
                    }
                    // 뚫고 왔으면 "O"라는 얘기
                    visited[nx][ny] = true;
                    for(int j = 0; j < 4; j++) {
                        int nnx = nx + dx[j];
                        int nny = ny + dy[j];

                        if(nnx < 0 || nny < 0 || nnx >= 5 || nny >= 5) continue;
                        if(visited[nnx][nny]) continue;
                        if("P".equals(map[nnx][nny])) {
                            flag = 0;
                            break;
                        }
                    }
                }

            }

            answer[tc] = flag;
        }


        return answer;
    }
}
