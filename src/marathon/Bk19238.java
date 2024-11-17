package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk19238 {

    static int n, m, oil;
    static int[][] map;
    static boolean[][] visited;
    static Location taxi;
    static Location[] customer;
    static Location[] arrive;
    static int nowCustomerNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        customer = new Location[m + 1];
        arrive = new Location[m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1; // 벽을 -1로
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            customer[i] = new Location(x, y, 0);
            map[x][y] = i; //손님 번호+위치 기록


            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arrive[i] = new Location(x, y, 0);
        }

        int count = 0;
        while (count < m) {
            //최단거리 손님 찾기
            findCustomer();
            if (oil <= 0) {
                System.out.println(-1);
                break;
            }
            //손님 모시고 목적지 가기
            goToGoal();
            if (oil < 0) {
                System.out.println(-1);
                break;
            }
            count++;
        }
        if (count == m) {
            System.out.println(oil);
        }
    }

    public static void findCustomer() {
        PriorityQueue<Location> pq = new PriorityQueue<>();
        visited = new boolean[n + 1][n + 1];
        pq.add(taxi);
        visited[taxi.x][taxi.y] = true;

        while (!pq.isEmpty()) {
            Location nowTaxi = pq.poll();
            //탈출조건
            if (map[nowTaxi.x][nowTaxi.y] > 0) {// 손님을 만났을떄
                nowCustomerNum = map[nowTaxi.x][nowTaxi.y];
                taxi = new Location(nowTaxi.x, nowTaxi.y, 0);
                map[nowTaxi.x][nowTaxi.y] = 0;
                oil -= nowTaxi.distance;
                return;
            }
            //반복
            for (int i = 0; i < 4; i++) {
                int nx = nowTaxi.x + dx[i];
                int ny = nowTaxi.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue; //나가면
                if (map[nx][ny] == -1) continue;//벽이면
                if (visited[nx][ny]) continue; // 갔으면

                visited[nx][ny] = true;
                pq.add(new Location(nx, ny, nowTaxi.distance + 1));
            }
        }
        //큐 다돌았는데 손님한테 못갔음 -> 접근할 수 있는 손님이 없음
        oil = -1;
    }

    public static void goToGoal() {
        Queue<Location> q = new LinkedList<>();
        visited = new boolean[n + 1][n + 1];
        q.add(taxi);
        visited[taxi.x][taxi.y] = true;

        int goalX = arrive[nowCustomerNum].x;
        int goalY = arrive[nowCustomerNum].y;

        while (!q.isEmpty()) {
            Location nowTaxi = q.poll();
            //탈출조건
            if (nowTaxi.x == goalX && nowTaxi.y == goalY) {
                if (oil - nowTaxi.distance >= 0) {
                    taxi = new Location(nowTaxi.x, nowTaxi.y, 0);
                    oil += nowTaxi.distance; //뺐다가 2배 더하니까 그냥 더함
                    return;
                }
                oil = -1;
            }
            //반복
            for (int i = 0; i < 4; i++) {
                int nx = nowTaxi.x + dx[i];
                int ny = nowTaxi.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue; //나가면
                if (map[nx][ny] == -1) continue;//벽이면
                if (visited[nx][ny]) continue; // 갔으면

                visited[nx][ny] = true;
                q.add(new Location(nx, ny, nowTaxi.distance + 1));
            }
        }
        //다돌아봤는데 목적지 도착을 못함!
        oil = -1;
    }

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static class Location implements Comparable<Location> {
        int x, y, distance;

        public Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Location o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }
    }
}
