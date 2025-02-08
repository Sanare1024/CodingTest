package programmers.kakao;

import java.util.*;

public class Donut {
    //도넛 = 크기 n 정점 n개 간선 n개 원래 정점으로 돌아오게됨
    //막대 = 크기 n 정점 n개 간선 n - 1개 끝에가면 나가는 간선 사라짐
    //8자 = 크기 n 정점 2n + 1개 간선 2n + 2개
    ArrayList<Integer>[] edgeLists;

    public int[] solution(int[][] edges) {
        // 생성점 찾기
        int startNum = 0;

        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        edgeLists = new ArrayList[max + 1];
        for (int i = 0; i < max + 1; i++) {
            edgeLists[i] = new ArrayList<>();
        }

        int start[] = new int[max + 1];
        int end[] = new int[max + 1];
        for (int[] edge : edges) {
            start[edge[0]]++;
            end[edge[1]]++;
            edgeLists[edge[0]].add(edge[1]);
        }
        for (int i = 1; i < max + 1; i++) {
            if (end[i] == 0 && start[i] > 1) {
                startNum = i;
            }
        }


        if (startNum == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[4];
        answer[0] = startNum;
        for (int startEdge : edgeLists[startNum]) {
            int form = dfs(startEdge,startEdge);
            answer[form]++;
        }
        return answer;
    }

    public int dfs(int n, int startEdge) {
        ArrayList<Integer> arr = edgeLists[n];
        if(arr.size() == 0){
            return 2;
        }
        if(arr.size() == 2){
            return 3;
        }
        if(arr.get(0) == startEdge){
            return 1;
        }
        return dfs(arr.get(0),startEdge);
    }
}
