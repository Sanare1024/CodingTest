package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bk1753_dijkstra {

    static int v, e, k;
    static int distance[];
    static ArrayList<Edge> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        distance = new int[v + 1];
        list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++){
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= v; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, w)); // u에서 v로 가는 가중치 w짜리 간선
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++){
            if(distance[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            int len = list[now.vertex].size();
            for(int i = 0; i < len; i++){
                Edge next = list[now.vertex].get(i);
                if(distance[next.vertex] > distance[now.vertex] + next.value){
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge n) {
            return this.value - n.value;
        }
    }
}
