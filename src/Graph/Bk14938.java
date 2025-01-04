package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bk14938 {
    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) { // 거리순으로 정렬
            return value - o.value;
        }
    }
    static int n, m, r;
    static int[] item;
    static ArrayList<ArrayList<Node>> list; //인접리스트
    static int[] distance; // 거리
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //양방향 인접리스트
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, value));
            list.get(end).add(new Node(start, value));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start) {
        //리셋
        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[n + 1];


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.index;

            if (!visited[index]) { // 간적없으면
                visited[index] = true; // 체크

                for (Node node : list.get(index)) {
                    if (visited[node.index]) continue;
                    if (distance[node.index] > distance[index] + node.value) {
                        distance[node.index] = distance[index] + node.value;
                        pq.add(new Node(node.index, distance[node.index]));
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] <= m) { //이동할 수 있는 거리내의
                res += item[i]; // 모든 아이템을 합치기
            }
        }
        return res;
    }
}
