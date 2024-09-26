package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk2252 {
    static int n, m;
    static int[] count;
    static ArrayList<ArrayList<Integer>> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++){
            list.add(new ArrayList<>());
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            count[b]++; //진입차수 배열 데이터 저장하는 부분
        }
        topologicalSort();

        System.out.println(sb);
    }

    public static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        // 앞 학생이 필요없는 학생 -> queue에 저장
        for(int i = 1; i <= n; i++){
            if(count[i] == 0){ // 앞학생이 없는 경우
                q.add(i);
            }
        }
        //위상 정렬 탐색 진행
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            //비교한 학생들 탐색하기
            for (int next : list.get(now)){
                count[next]--; // 앞 학생이 줄에 포함되었으므로 -1
                if(count[next] == 0) { //앞 학생이 모두 없어진경우
                    q.add(next);
                }
            }
        }
    }
}
