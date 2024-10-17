package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw1251_1 {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            long[] x = new long[n];
            long[] y = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                x[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                y[i] = Long.parseLong(st.nextToken());
            }
            double e = Double.parseDouble(br.readLine());

            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++){
                for (int j = i + 1; j < n; j++){
                    long lengthL = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                    pq.add(new Node(i, j, lengthL));
                }
            }

            int answer = 0;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(find(now.start) != find(now.end)){
                    answer += now.value;
                    union(now.start, now.end);
                }
            }

            System.out.println("#" + tc + " " + Math.round(e * answer));
        }
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            parent[b] = a;
            return false;
        }
        return true;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        long value;

        public Node(int start, int end, long value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);
        }
    }
}
