package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bk1504_dijkstra {

    static int n, e;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] list; // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c)); //a에서 b목표로 갈때 거리 c
            list[b].add(new Node(a, c)); //양방향이면 2번 넣으라고 했음
        }

        //반드시 거쳐야하는 2정점 받기
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int caseV1 = 0; // 1 -> v1 -> v2 -> n 으로 가는경우
        int caseV2 = 0; // 1 -> v2 -> v1 -> n 으로 가는경우

        caseV1 += dijkstra(1, v1);
        caseV1 += dijkstra(v1, v2);
        caseV1 += dijkstra(v2, n);

        caseV2 += dijkstra(1, v2);
        caseV2 += dijkstra(v2, v1);
        caseV2 += dijkstra(v1, n);

        if(caseV1 >= 200000000 && caseV2 >= 200000000){
            System.out.println(-1);
        } else {
            int ans = Math.min(caseV1, caseV2);
            System.out.println(ans);
        }
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance = new int[n + 1]; // 최단거리 저장배열
        visited = new boolean[n + 1]; //방문 여부

        for(int i = 0; i < n + 1; i++){
            distance[i] = 200000000;
        }

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();

            int nowNode = now.targetNode;
            int nowDis = now.value;

            if (visited[nowNode]) continue; //방문했으면 스킵
            visited[nowNode] = true;
            for (Node next : list[nowNode]){
                if(visited[next.targetNode]) continue; //다음에 갈곳이 방문했으면 스킵
                if(distance[next.targetNode] > distance[nowNode] + next.value){
                    distance[next.targetNode] = distance[nowNode] + next.value;
                    pq.add(new Node(next.targetNode, distance[next.targetNode]));
                }
            }
        }

        return distance[end];
    }


    static class Node implements Comparable<Node>{
        int targetNode;
        int value;
        public Node (int targetNode, int value){
            this.targetNode = targetNode;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}
