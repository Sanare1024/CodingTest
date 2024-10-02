package dfs.backtracking;

import java.util.Scanner;

public class Bk15651 {

    static int N,M;
    static int res[];
    static StringBuilder sb= new StringBuilder();;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        res=new int[N];
        permutation(0);
        System.out.print(sb.toString());
    }

    static void permutation(int cnt) {
        if(cnt==M) {//기저조건
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");//결과
            return;
        }

        for (int i = 1; i <= N; i++) {// i: 시도하는 숫자.
            res[cnt]=i;//뽑은거 넣는다.
            permutation(cnt+1);
            //i를 선택하고 나올 수 있는 모든 상태가 생성됨.
        }
    }
}
