package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bk2623 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static int[] lineUp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        lineUp = new int[n + 1];

        for (int i = 0; i <= n; i++) { //리스트 초기화
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); //담당 가수 수
            int first = Integer.parseInt(st.nextToken()); //첫째 가수

            for (int j = 1; j < num; j++) {
                int nextSinger = Integer.parseInt(st.nextToken());
                list.get(first).add(nextSinger); //리스트에 다음 가수 순서 넣기
                lineUp[nextSinger]++; //진입 차수 배열에 저장

                first = nextSinger; // 다음가수 앞으로 꺼내기
            }
        }

        topologicalSort();

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (lineUp[i] != 0) { //다 정렬했는데 진입차수가 남아있는게 있으면 순서가 안정해지니까 0 출력
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (lineUp[i] == 0) { //진입 차수가 0이면 큐에 넣
                q.add(i);
            }
        }
        //위상 정렬
        while (!q.isEmpty()) {
            int nowSinger = q.poll();
            sb.append(nowSinger).append("\n"); //순서 뱉고 줄띄고
            //다음 가수 탐색
            for (int next : list.get(nowSinger)) {
                lineUp[next]--; // 가수를 줄에 넣었으니 -1
                if (lineUp[next] == 0) { //줄여 나가다가 진입차수가 0되면 다시 큐에 넣기
                    q.add(next);
                }
            }
        }
    }
}
