package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk10026 {

    static int n;
    static boolean[][] visited;
    static char[][] zido;
    static Queue<Node> queue = new LinkedList<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        zido = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < n; j++){
                zido[i][j] = temp.charAt(j);
            }
        }

        int countNomal = 0; //구역
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    countNomal++;
                    bfs(new Node(i, j));

                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(zido[i][j] == 'G'){
                    zido[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        int countCW = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    countCW++;
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(countNomal + " " + countCW);

    }

    public static void bfs(Node start){
        queue.add(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Node currentNode = queue.poll(); //뽑
            //탈출조건 : 다뽑
            //할일 : 뽑으면서 이동
            for (int i = 0; i < 4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;//나가면
                if(visited[nx][ny]) continue;//갔으면
                if(zido[currentNode.x][currentNode.y] != zido[nx][ny]) continue;//현재 노드랑 이동할 노드가 색이 다르면
                //조건 통과? 갈거야
                visited[nx][ny] = true;
                queue.add(new Node(nx,ny));
            }
        }

    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
