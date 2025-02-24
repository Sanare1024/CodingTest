package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bk16236 {

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int n, sharkX, sharkY, sharkSize = 2, time, eatCount = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;

                    map[i][j] = 0;
                }
            }
        }

        int timeSum = 0;
        //부모가 옮기지 않아도 될 때 계속 반복
        while (sharkGo()) {
            timeSum += time;
        }

        System.out.println(timeSum);
    }

    static boolean sharkGo() {
        time = 0;
        //먹은 물고기의 수가 몸의 크기와 같아지면 몸의 크기 증가
        if (eatCount == sharkSize) {
            eatCount = 0;
            sharkSize++;
        }

        boolean[][] visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node now = q.poll();
            //최소 시간으로 물고기를 먹을 수 있는 시간을 넘으면 종료
            if (now.time >= minTime) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                //아기 상어가 먹을 수 있는 물고기가 있는 칸에 들어옴
                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    if (nx < minX) {
                        minX = nx;
                        minY = ny;
                        minTime = now.time + 1;
                    } else if (nx == minX) {
                        if (ny < minY) {
                            minY = ny;
                            minTime = now.time + 1;
                        }
                    }
                }

                q.offer(new Node(nx, ny, now.time + 1));
                visited[nx][ny] = true;
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            return false;
        } else {
            sharkX = minX;
            sharkY = minY;
            eatCount++;
            time = minTime;
            map[sharkX][sharkY] = 0;

            return true;
        }
    }
}
