package bruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class Bk17471 {
    static boolean checkRed[];
    static int N;
    static int res;
    static int popul[];
    static boolean visited[];
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        res = Integer.MAX_VALUE;
        popul = new int[N+1];
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            popul[i] = sc.nextInt();
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <=N; i++) {
            int L = sc.nextInt();
            for (int j = 0; j < L; j++) {
                adjList[i].add(sc.nextInt());
            }
        }

        checkRed = new boolean[N+1];
        powerSet(1);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void powerSet(int cnt) {
        if(cnt == N+1) {
            visited  = new boolean[N+1];
            //부분 집합 다구했음
            if(isConnected()) {
                int sumRed = 0;
                int sumBlue = 0;

                for (int i = 1; i < N+1; i++) {
                    if(checkRed[i])
                        sumRed+=popul[i];
                    else
                        sumBlue+=popul[i];
                }

                res = Math.min(res,Math.abs(sumBlue-sumRed));

            }
            return;
        }

        checkRed[cnt] = true;
        powerSet(cnt+1);

        checkRed[cnt] = false;
        powerSet(cnt+1);

    }

    private static boolean isConnected() {
        // TODO Auto-generated method stub

        int redstart=-1;
        int bluestart=-1;

        for (int i = 1; i <= N; i++) {
            if(checkRed[i])
                redstart=i;
            else
                bluestart=i;
        }

        if(redstart == -1 || bluestart == -1) {//각자 하나라도 선거구가 존재해야함
            return false;
        }

        dfsR(redstart);
        dfsB(bluestart);

        for (int i = 1; i <= N; i++) {
            if(!visited[i])
                return false;
        }

        return true;

    }

    private static void dfsR(int start) {
        visited[start]=true;
        for (int node : adjList[start]) {
            if(checkRed[node] && !visited[node]) {//red의 노드가 맞으면
                dfsR(node);
            }
        }
    }

    private static void dfsB(int start) {
        visited[start]=true;
        for (int node : adjList[start]) {
            if(!checkRed[node] && !visited[node]) {//blue의 노드가 맞으면
                dfsB(node);
            }
        }
    }
}
