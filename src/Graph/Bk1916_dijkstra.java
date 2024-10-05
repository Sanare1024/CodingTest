package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bk1916_dijkstra {

    static int n, m;
    static ArrayList<Node>[] list;      //인접 리스트로 그래프 표현
    static int distance[];                //최단 거리 배열
    static boolean[] visited;           //사용 노드인지 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < list.length; i++){ // 최단거리배열 큰수로 초기화
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n; i++){
            list[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){ //그래프 엣지를 인접리스트 자료구조에 넣기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startcity = Integer.parseInt(st.nextToken());
        int endcity = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(dijkstra(startcity, endcity)).append("\n");
        System.out.println(sb);
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowTarget = now.targetNode;

            if(!visited[nowTarget]){// 간적 없다면
                visited[nowTarget] = true;
                for (Node n : list[nowTarget]){ // 타겟노드 > 선택노드 + 비용 일때 값 업데이트
                    if(visited[n.targetNode]) continue;
                    if(distance[n.targetNode] > distance[nowTarget] + n.value){
                        distance[n.targetNode] = distance[nowTarget] + n.value;
                        pq.add(new Node(n.targetNode, distance[n.targetNode]));
                    }
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


