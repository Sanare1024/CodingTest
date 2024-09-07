package disjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1717 {

    static int n, m;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new int[n + 1];
        init();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if ((order == 0)){
                union(a,b);
            } else { //order 가 1일때
                if(findSet(a) == findSet(b)){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static int findSet(int a){ //a가 어디소속인지 알려줄 애
        if(set[a] == a) return a; //만약 set[a] == a라면 (a노드 가 aRoot라면) 본인을 리턴
        return set[a] = findSet(set[a]); // 아니라면 a노드의 뿌리로 한번 더 탐색
        //return findset(set[a]) //이렇게 할경우에 할때마다 반복해서 시간이 늘어남
        // 이것을 위 방법으로 바꿔서 메모이제이션으로 시간을 최적화한다
    }

    private static boolean union(int a, int b){ // 집합 결합시키는 얘
        int aRoot = findSet(a); //a소속
        int bRoot = findSet(b); //b소속

        if (aRoot == bRoot) return false; //뿌리가 같으면 이미 결합되어 있으니까 false
        set[aRoot] = bRoot;
        return true;
    }
    private static void init() {
        for(int i = 0; i < n + 1; i++){
            set[i] = i;
        }
    }

}
