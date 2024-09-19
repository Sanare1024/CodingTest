package dfs.backtracking;

import java.util.Scanner;

public class Bk15649 {

    static int n, m;
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) { // 중복x 순열
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        m  = sc.nextInt();

        arr = new int[m];
        selected = new boolean[n];

        dfs(0);
    }

    public static void dfs(int cnt){
        if(cnt == m){ //m개만큼 다 뽑
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++){
            if(selected[i]) continue; //고른거 패스, 중복없이
            arr[cnt] = i + 1;
            selected[i] = true;
            dfs(cnt + 1);
            selected[i] = false;
        }
    }
}
