package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk12851 {

    static int n, k;
    static int time = Integer.MAX_VALUE; // 시간 최소값 넣을곳
    static int count = 0; // 경우의 수
    static int[] visitTime; //갔던 시간 등록
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visitTime = new int[100001];

        if(n >= k){ //동생이 같이 있거나 뒤에 있으면 -1씩 가는거밖에 없으니까
            System.out.println(n - k); // n - k 횟수
            System.out.println(1); // 경우의 수 1가지
            return;
        }

        bfs();

        System.out.println(time);
        System.out.println(count);
    }

    public static void bfs(){
        q = new LinkedList<>();
        q.add(new Node(n, 0));
        visitTime[n] = 1; //스타트 표시
        while(!q.isEmpty()){
            Node now = q.poll();
            //탈출조건
            if(now.sis == k){ //누나가 동생한테 닿았을때
                if(count == 0){ //처음 닿았으면 최소시간 갱신
                    time = now.sec;
                    count++;
                } else if(count != 0 && now.sec == time){ //처음닿은건 아니지만 갱신한 최소시간이랑 같은거(다른 경우의 수)
                    count++;
                }
                continue; //브레이크말고 컨티뉴해서 큐에 들어간거 다 나오게 해야함
            }
            //할일
            int move[] = {now.sis - 1, now.sis + 1, now.sis * 2}; //뒤로가거나 앞으로가거나 x2하거나
            for (int i = 0; i < 3; i++) {
                int moveSis = move[i];
                if(moveSis < 0 || moveSis > 100000) continue; //범위 나가면
                if(visitTime[moveSis] == 0 || visitTime[moveSis] == now.sec + 1){//한번도 안 온곳이나 이미 방문했더라도 같은시간에 방문했을경우
                    visitTime[moveSis] = now.sec + 1;
                    q.add(new Node(moveSis, now.sec + 1));
                }
            }
        }
    }

    static class Node{
        int sis;
        int sec;

        public Node(int sis, int sec) {
            this.sis = sis;
            this.sec = sec;
        }
    }
}
