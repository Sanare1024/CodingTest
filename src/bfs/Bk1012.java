package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bk1012 {

    static int m,n; // 밭 가로세로
    static boolean[][] visited; //간곳체크
    static int[][] vat; //밭

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int a = 0; a < t; a++){ //테스트케이스 돌리기
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt(); //배추개수

            vat = new int[m][n]; //테스트 케이스마다 새로해야하니까 여기에
            visited = new boolean[m][n];
            int worm = 0; //지렁이 개수

            //배추심기
            for(int i = 0; i < k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                vat[x][y] = 1;
            }

            //========================================///
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(vat[i][j] == 1 && !visited[i][j]){
                        move(new Node(i,j)); // 노드로 i j 넣기
                        worm++;
                    }
                }
            }
            System.out.println(worm);//답
        }
    }

    static int[] dx = {-1,1,0,0};//좌우상하
    static int[] dy = {0,0,-1,1};

    public static void move (Node start){
        Queue<Node> queue = new LinkedList<>();//선입 선출
        queue.add(start);// 배추가 심어진곳 + 안간곳 조건성립되는곳부터 시작

        while (!queue.isEmpty()){ //큐가 아예 빌때까지 반복
            Node currentNode = queue.poll();//지금 꺼 빼내기. 제일 먼저들어간거(add한 지점)
            //탈출 조건 : 지금은 없음 배추밭은 다돌면 자동끝
            //할 일 : 심어진 배추에서 이어진 배추 다돌기
            for (int i = 0; i < 4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;//나가면
                if(visited[nx][ny]) continue;//갔으면

                if(vat[nx][ny] == 1 && !visited[nx][ny]){ //위에 시작조건이랑 똑같
                    queue.add(new Node(nx,ny)); // 조건맞으면 노드에 넣어
                    visited[nx][ny] = true; // 넣으면서 간곳은 체크
                }
            }


        }
    }

    static class Node{ //int y
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
