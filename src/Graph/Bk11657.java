package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bk11657 {
    static int n, m;
    static long distance[];
    static Edge edges[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m + 1];
        distance = new long[n + 1];
        for (int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken()); // 음수가능 타임머신

            edges[i] =  new Edge(start, end, time);
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord(1)){
            for (int i = 2; i < n + 1; i++){
                if(distance[i] == Integer.MAX_VALUE){
                    sb.append("-1\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        } else {
            sb.append("-1\n");
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord(int start){
        //시작부분 0으로 초기화
        distance[start] = 0;
        //n - 1 만큼 반복
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Edge edge = edges[j];
                //더 작은 최단거리가 있을 때 업데이트
                if(distance[edge.start] == Integer.MAX_VALUE) continue;
                if(distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        //음수 싸이클 확인
        //갱신되는게 있으면 음수 사이클임
        for (int i = 0; i < m; i++){
            Edge edge = edges[i];
            if(distance[edge.start] == Integer.MAX_VALUE) continue;
            if(distance[edge.end] > distance[edge.start] + edge.time){
                return false;
            }
        }
        return true;
    }

    static class Edge{
        int start;
        int end;
        int time;

        public  Edge(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}