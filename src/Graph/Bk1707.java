package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bk1707 {

    static int k, v, e;
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean flag; // 이분그래프인지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            flag = true;

            for (int i = 1; i <= v; i++){
                list[i] = new ArrayList<Integer>();
            }

            //엣지 데이터 저장하기
            for (int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                //방향이 없음 -> 양쪽에 다 넣어줘야함
                list[start].add(end);
                list[end].add(start);
            }
            //모든 노드에서 dfs실행
            for(int i = 1; i <= v; i++){
                if (flag){// 이분그래프일 경우에 dfs돌리고
                    dfs(i);
                } else { // 하나라도 아니라고 나오면 멈추기
                    break;
                }
            }

            if (flag) { //다돌렸는데 flag변화 없으면 이분그래프
                System.out.println("YES");
            } else { // 이분그래프 아님
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int node){
        visited[node] = true; //시작부분 방문표시해놓고 시작

        for(int i : list[node]){ //인접리스트로 받아서 node에서 연결된 모든노드를 탐색
            if(!visited[i]){
                //바로 직전의 있었던 노드와 다른 집합으로 분류를 해주는것이 필요
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            } else if(check[node] == check[i]) {//이미 방문한걸 만났을대 이전의 노드랑 앞에 있는 노드가 같은 집합이면
                                                //이분그래프가 아니게 되니까 표시를 함
                flag = false;
            }
        }
    }
}
