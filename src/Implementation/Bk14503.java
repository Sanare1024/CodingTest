package Implementation;

import java.io.*;
import java.util.*;
public class Bk14503 {

    static int n, m, r, c, d;
    static int count; // 청소한칸
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //(r, c) d는 방향(0: 북, 1: 동, 2: 남, 3: 서)
        //map[i][j] = 0 은 청소안된곳, 1은 벽
        //작동한번하고 멈출때까지 청소한 칸 개수

        count = 1; //입장청소
        clean(r, c, d);

        System.out.println(count);
    }

    //청소한다 -> 4칸정찰
    // if 전부다 청소된 경우 -> 바라보는방향 유지한 채로 뒤로 한칸 후진 후 다시 재귀(뒤가 벽이면 작동 종료)
    // else 4칸중 청소 안된 경우 -> 반시계 방향으로 90도 회전(회전 후 앞쪽이 청소 되지않았으면 한칸 전진) 이후 재귀

    public static void clean(int x, int y, int direction){
        map[x][y] = 2; //입장 청소

        //4칸 탐색
        boolean dirty = true;
        for(int i = 0; i < 4; i++){ //주변 4칸 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(map[nx][ny] == 0) { //한 곳이라도 더러운곳이 있다면
                dirty = false;
            }
        }

        //작동
        if(dirty){//청소가 된경우
            int turn = (direction + 2) % 4; //뒤로 후진해야하니까 꽁지방향
            int nx = x + dx[turn];
            int ny = y + dy[turn];
            if(nx >= 0 && ny >=0 && nx < n && ny < m && map[nx][ny] != 1){ //맵을 나가지 않고 뒤가 벽이 아니면
                clean(nx, ny, direction); // 뒤로 이동 후 다시 청소
            }
        } else {// 청소가 안된경우 대가리 반시계 90도(-1) 앞쪽이 청소되지 않았으면 한칸 전진
            direction -= 1; //반시계 회전
            if(direction == -1) direction = 3;

            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(nx >= 0 && ny >=0 && nx < n && ny < m && map[nx][ny] == 0){ //나가지 않고 앞이 청소가 안된 곳이면
                count++;
                clean(nx, ny, direction); // 앞으로 이동 후 청소
            } else {
                clean(x, y, direction); // 아니면 제자리
            }
        }
    }

    //북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
}
