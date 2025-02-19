package goldRun;

import java.util.*;
import java.io.*;

public class Bk2211 {
    static int n;
    static List<List<Node>> list = new ArrayList<>();
    static List<Node> answer = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int start, end, distance;

        Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node a) {
            return this.distance - a.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(A, B, val));
            list.get(B).add(new Node(B, A, val));
        }

        dijkstra();

        System.out.println(answer.size());
        for (Node node : answer) {
            System.out.println(node.start + " " + node.end);
        }
    }

    static void dijkstra() {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dist[i] = Integer.MAX_VALUE;

        //각각의 노드에는 목표 정점(to)과 그 정점으로 가기 직전의 정점(from),
        //시작 정점에서 목표 정점까지의 거리(val)을 저장
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 1, 0));
        visited[1] = true;
        dist[1] = 0;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            if (!visited[vertex.end]) {
                visited[vertex.end] = true;
                answer.add(vertex);
            }

            for (int i = 0; i < list.get(vertex.end).size(); i++) {
                Node nextV = list.get(vertex.end).get(i);

                if (dist[nextV.end] > dist[vertex.end] + nextV.distance) {
                    dist[nextV.end] = dist[vertex.end] + nextV.distance;
                    q.offer(new Node(nextV.start, nextV.end, dist[nextV.end]));
                }
            }
        }
    }
}

