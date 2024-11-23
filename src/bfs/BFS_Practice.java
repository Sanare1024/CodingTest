package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Practice {

    //BFS 먼저 도착하면. 무조건 최단.

    static int result;
    static int N = 6;

    static int[][] map = {//탈출을 하되. 제일 빨리 탈출 길이
            {0,1,1,1,2,0},
            {0,0,0,0,1,0},
            {0,1,1,0,1,0},
            {0,1,0,0,0,0},
            {0,1,1,0,1,1},
            {0,1,1,0,0,2}
    };

    public static boolean[][] visited = new boolean[N][N];

    //길이. 좌표.
    public static void main(String[] args) {
        result = Integer.MAX_VALUE;//내가 최단 거리 구할꺼니까 일단 높은 값.
        visited[0][0] = true;//시작부
        go(new Node(0,0,0));
    }

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void go(Node start){
        Queue<Node> queue = new LinkedList<>();//선입 선출
        queue.add(start);

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();//지금 꺼 빼내기. 제일 먼저들어간거.
            //탈출 조건
            if(map[currentNode.y][currentNode.x] == 2){
                System.out.println(currentNode.y + " : " + currentNode.x  + " => " + currentNode.len);
                result = Math.min(result, currentNode.len);
                break;
            }
            //할 일
            for (int i = 0; i < 4; i++) {
                int ny = currentNode.y + dy[i];
                int nx = currentNode.x + dx[i];
                int nl = currentNode.len + 1;

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;//나가면
                if(map[ny][nx] == 1) continue;//벽이면
                if(visited[ny][nx]) continue;//갔으면

                //나 갈거야
                visited[ny][nx] = true;
                //BFS queue 쌓아줌 vs DFS 재귀 호출
                queue.add(new Node(ny,nx,nl));
            }

        }

    }

    static class Node{ //int y
        int y;
        int x;
        int len;

        public Node(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }
}
