package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk17472_MST {

    static int n, m, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] parent;
    static PriorityQueue<MST_Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. BFS로 돌면서 섬 번호 붙이기
        int islandNum = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    Numbering_BFS(i, j, islandNum);
                    islandNum++;
                }
            }
        }
        // 2. DFS로 섬에서 출발해서 한방향으로 다리 잇기
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] != 0){
                    for (int k = 0; k < 4; k++){
                        BuildBridge(i, j, map[i][j], k, -1);
                    }
                }
            }
        }
        // 3. 크루스칼로 섬 최소거리 구하기
        ans = -1;
        shortestBridge(islandNum);
        System.out.println(ans);
    }

    public static void Numbering_BFS(int x, int y, int num){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        map[x][y] = num;
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1){
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void BuildBridge(int x, int y, int num, int dir, int length) {
        // 탈출조건 : 다른섬을 만나기 +  멈추기
        if(map[x][y] != 0 && map[x][y] != num){
            if(length >= 2) pq.add(new MST_Node(num, map[x][y], length));
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || ny < 0 || nx >= n || ny >= m) return;
        if(map[nx][ny] == num) return;
        BuildBridge(nx, ny, num, dir, length + 1);
    }

    public static void shortestBridge(int islandNum){ // islandNum은 섬개수 + 1
        parent = new int[islandNum];
        for (int i = 1; i < islandNum; i++){
            parent[i] = i;
        }

        int sum = 0;
        int count = 0;
        while(!pq.isEmpty()){
            MST_Node current = pq.poll();

            int a = find(current.start);
            int b = find(current.end);

            if(a != b){
                sum += current.value;
                count++;
                union(a, b);
            }
        }

        if (count != islandNum - 2) return;
        ans = sum;
    }


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; //좌하우상

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

    static class MST_Node implements Comparable<MST_Node> {
        int start;
        int end;
        int value;

        public MST_Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(MST_Node o) {
            return this.value - o.value;
        }
    }

    static class Node {
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
