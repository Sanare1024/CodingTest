package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk2637 { //장난감 조립 // 위상정렬
    static int[] indegree_y;
    static ArrayList<Node>[] list;

    public static class Node {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] indegree_x = new int[n + 1]; //기본 부품 찾기 용도
        indegree_y = new int[n + 1]; //위상정렬 용도
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, k));
            indegree_x[x]++;
            indegree_y[y]++;
        }
        //입력 끝

        int[] result = topologySort(n);
        for (int i = 1; i <= n; i++) {
            if (indegree_x[i] == 0) System.out.println(i + " " + result[i]);
        }
    }

    public static int[] topologySort(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 1));
        int[] counter = new int[n + 1];
        counter[n] = 1;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < list[current.num].size(); i++) {
                Node next = list[current.num].get(i);
                counter[next.num] += counter[current.num] * next.count;
                indegree_y[next.num]--;
                if (indegree_y[next.num] == 0) {
                    q.offer(new Node(next.num, counter[next.num]));
                }
            }
        }
        return counter;
    }
}
