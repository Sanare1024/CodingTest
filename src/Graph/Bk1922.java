package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bk1922 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, e, v));
        }

        int result = 0;
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.start) != find(now.end)){
                result += now.value;
                union(now.start, now.end);
            }
        }

        System.out.println(result);
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            parent[b] = a;
        }
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        public Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
