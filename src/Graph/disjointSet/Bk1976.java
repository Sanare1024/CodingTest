package Graph.disjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1976 {

    static int n, m;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        set = new int[n + 1];

        //배열에 넣기
        for(int i = 1; i < n + 1; i++){
            set[i] = i;
        }

        //연결 정보 넣기
        for(int i = 1; i < n + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){//연결을 입력받으면 연결시켜
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i = 0; i < m - 1; i++){
            int nextCity = Integer.parseInt(st.nextToken());
            if (findSet(startCity) != findSet(nextCity)){
                System.out.println("NO");
                return; //경로가 아니면 바로 종료
            }
        }//다돌고 나온거면 경로가 맞은거니까 Yes
        System.out.println("YES");
    }

    static int findSet(int a){ //a소속 찾기
        if(set[a] == a) return a; //뿌리면 본인리턴
        return set[a] = findSet(set[a]); // 뿌리가 아니면 한번더 깊이 탐색
    }

    static void union(int a, int b){
        int aRoot = findSet(a); //a 뿌리찾기
        int bRoot = findSet(b); //b 뿌리찾기

        if(aRoot == bRoot) return; //같으면 리턴
        set[aRoot] = bRoot; // 연결시키기
    }
}
