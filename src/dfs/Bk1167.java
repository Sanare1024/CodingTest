package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk1167 {
    static int n;
    static ArrayList<ArrayList<Node>> list;
    static int endNode;
    static boolean[] visited;
    static int ans;

    static class Node {
        int node;
        int dis;

        public Node(int node , int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                int target = Integer.parseInt(st.nextToken());
                if (target == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                list.get(node).add(new Node(target - 1, distance));
            }
        }

        visited = new boolean[n];
        dfs(0, 0);

        visited = new boolean[n];
        dfs(endNode, 0);

        System.out.println(ans);
    }

    static void dfs(int node, int distance) {
        //탈출 조건
        if (distance > ans) {
            ans = distance;
            endNode = node;
        }
        // 반복 돌면서 최대 거리 노드까지 가기
        visited[node] = true;

        for (int i = 0; i < list.get(node).size(); i++) {
            Node now = list.get(node).get(i);
            if (!visited[now.node]) {
                dfs(now.node, now.dis + distance);
                visited[now.node] = true;
            }
        }
    }
}
