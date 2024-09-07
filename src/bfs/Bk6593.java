package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk6593 {

    static int l, r, c;
    static char[][][] map;
    static boolean [][][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static Node start;
    static Node end;
    static boolean escape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c =Integer.parseInt(st.nextToken());

            int startL = 0;
            int startR = 0;
            int startC = 0;
            escape = false;

            if(l == 0 && r == 0 && c == 0){
                break;
            }
            map = new char[l][r][c];  //l 층 rc 세로 가로
            visited = new boolean[l][r][c];

            for(int i = 0; i < l; i++){

                for (int j = 0; j < r; j++) {
                    String str = br.readLine();

                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = str.charAt(k);

                        if(map[i][j][k] == 'S'){
                            start = new Node(k,j,i,0);
                        } else if (map[i][j][k] == 'E') {
                            end = new Node(k,j,i,0);
                        }
                    }
                }

                String temp = br.readLine();
            }

            bfs(start);

            if (!escape) { // bfs가 끝났는 데도 탈출 체크가 안된다면
                System.out.println("Trapped!");
            }

        }
    }

    public static void bfs(Node node) {
       Queue<Node> queue = new LinkedList<>();
       queue.add(node);
       visited[node.z][node.y][node.x] = true;


       while(!queue.isEmpty()){
           Node cNode = queue.poll(); //뽑

           //탈출 조건 : end 만나면 끝
           if(cNode.x == end.x && cNode.y == end.y && cNode.z == end.z){ // 나가는곳과 같다면
               System.out.println("Escaped in "+ cNode.count +" minute(s).");
               escape = true; //탈출체크
               return;
           }
           //할 일 : 1  . 갈수있는곳 # 막힌곳
           //       2  층도 옮겨야함
           //       3 못나가면 Trapped
           for (int i = 0; i < 6; i++) {
               int nx = cNode.x + dx[i];
               int ny = cNode.y + dy[i];
               int nz = cNode.z + dz[i];
               int ncount = cNode.count;

               if(nx < 0 || ny < 0 || nz < 0|| nx >= c || ny >= r || nz >= l) continue; //나가면
               if(visited[nz][ny][nx]) continue; //갔으면
               if(map[nz][ny][nx] == '#') continue; //벽

               visited[nz][ny][nx] = true;

               queue.add(new Node(nx, ny, nz, ncount + 1));
           }
       }


    }

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Node{
        int x;
        int y;
        int z;
        int count;

        public Node(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
