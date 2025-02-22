package goldRun;

import java.util.*;
import java.io.*;

public class Bk1238 {
    static class node implements Comparable<node> {
        int position, value;

        public node(int position, int value) {
            this.position = position;
            this.value = value;
        }

        //오름차순
        @Override
        public int compareTo(node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<node>> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] distance = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.get(start).add(new node(end, time));
        }
        int answer = Integer.MIN_VALUE;

        //각 지역을 기준 최단 거리
        for (int i = 1; i <= n; i++) {
            bfs(i, distance, list);
        }
        //최대 소요시간 구하기
        for (int i = 1; i <= n; i++) {
            int d = distance[i][x] + distance[x][i];    //소요시간 점화식
            answer = Math.max(answer, d);    //최대값인지 확인
        }

        System.out.println(answer);
    }

    //다익스트라로 시작 구역에서 다른 지역에 가는 최단 거리를 구하는 함수입니다.
    static void bfs(int start, int[][] distance, ArrayList<ArrayList<node>> graph) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));  //시작 위치 저장
        distance[start][start] = 0;    //시작 지역 초기 위치 저장

        while (!pq.isEmpty()) {
            node cur = pq.poll();
            for (node next : graph.get(cur.position)) {
                int tempValue = cur.value + next.value;
                //이동하려는 지역이 최단 거리일 때
                if (distance[start][next.position] > tempValue) {
                    distance[start][next.position] = tempValue;
                    pq.add(new node(next.position, tempValue));
                }
            }
        }
    }
}
