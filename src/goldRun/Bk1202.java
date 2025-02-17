package goldRun;

import java.io.*;
import java.util.*;

public class Bk1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Gem> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Gem(m, v));
        }
        list.sort((o1, o2) -> o1.m - o2.m); //무게순 정렬

        int[] weight = new int[k];
        for (int i = 0; i < k; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight); // 무게 순 정렬

        long total = 0;
        int listIdx = 0;
        PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v); //가격순 정렬
        for (int i = 0; i < k; i++) {
            while (listIdx < n && list.get(listIdx).m <= weight[i]) {
                Gem current = list.get(listIdx++);
                pq.add(new Gem(current.m, current.v));
            }
            if (!pq.isEmpty()) total += pq.poll().v;
        }
        System.out.println(total);
    }

    public static class Gem {
        int m;
        int v;

        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
