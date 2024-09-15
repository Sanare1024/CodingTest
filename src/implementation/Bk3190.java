package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bk3190 {

    static int n, k, l, totalTime;
    static int[][] map;
    static Queue<Node> snake;
    static Queue<Spin> spin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a - 1][b - 1] = 4; //사과 위치
        }

        l = Integer.parseInt(br.readLine());
        spin = new LinkedList<>();

        for (int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            spin.add(new Spin(time, direction));
        }

        snakeMove();

        System.out.println(totalTime);
    }

    public static void snakeMove(){
        snake = new LinkedList<>(); //뱀 모뚱아리를 큐로 표현
        snake.add(new Node(0, 0)); //0,0 시작
        int x = 0;
        int y = 0;
        int dir = 0; //동쪽보고 시작
        totalTime = 0;
        int spinCount = 0;
        map[0][0] = -1; //뱀

        while(true){
            //앞에 방향에 대가리 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            totalTime++;

            //벽이나 자신의 몸에 부딪히면 끝
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            if(map[nx][ny] == -1) break;

            //만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            if(map[nx][ny] == 4){
                map[nx][ny] = -1;
                snake.add(new Node(nx, ny));
            } else {//만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다
                map[nx][ny] = -1;
                snake.add(new Node(nx, ny));

                Node tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }

            //머리 꺽기
            if(!spin.isEmpty()){
                if(totalTime == spin.peek().time){
                    Spin s = spin.poll();

                    if(s.direction.equals("L")){
                        dir = (dir + 3) % 4;
                    } else {
                        dir = (dir + 1) % 4;
                    }
                }
            }

            x = nx;
            y = ny;
        }
    }

    static int[] dx = {0, 1, 0, -1}; //동남서북 (0 1 2 3)
    static int[] dy = {1, 0, -1, 0};

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Spin{
        int time;
        String direction;

        public Spin(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
