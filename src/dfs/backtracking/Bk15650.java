package dfs.backtracking;

import java.util.Scanner;

public class Bk15650 {

    static int n, m;
    static int[] arr;
    public static void main(String[] args) { // 중복 x 조합
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(0,1);
    }

    public static void dfs(int cnt, int start){ // 중복없이
        if(cnt == m){
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++){

            arr[cnt] = i;
            dfs(cnt + 1, i+ 1); //내 다음것부터 뽑아 = 중복x

        }

    }
}
