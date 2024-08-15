package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Bk1260 {
    static int N,M,V;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end); //간선이 단방향일때
            map.get(end).add(start);//간선이 양방향일때
        }

        for (int i = 0; i <= N; i++) {
            map.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2; //오름차순 정렬
                }
            });
        }

        visited[V] = true;
        dfs(V);

        //TODO
        System.out.println();


        //BFS(V);
        visited = new boolean[N + 1];

        visited[V] = true;
        bfs(V);

    }

    static void dfs(int currentNode){
        System.out.print(currentNode + " ");
        ArrayList<Integer> vertexs = map.get(currentNode);
        for (int current :  vertexs) {
            if(visited[current]) continue;
            visited[current] = true;
            dfs(current);
        }
    }

    static void bfs(int currentNode){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(currentNode);

        while (!queue.isEmpty()){
            int now = queue.poll();//지금 꺼 빼내기
            System.out.print(now + " "); //빼낸거 출력
            //탈출조건 다 뺄때까지
            //할일 =  리스트안에 리스트 꺼내서 가지않은곳이면 큐에 집어넣기
            ArrayList<Integer> vertexs = map.get(now); // 꺼낸거 기준으로 map에서 간선 가져와

            for(int current : vertexs){ // 가져온 간선만큼 반복
                if(visited[current]) continue; //갔던데
                queue.add(current); // 아니면 큐에 넣어
                visited[current] = true; // 간거 체크
            }

        }
    }
}

