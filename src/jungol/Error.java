package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Error {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        N=Integer.parseInt(br.readLine());

        int[][] arr= new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[] row = new int[N];
        int[] col = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==1)
                    col[i]++;
                if(arr[j][i]==1)
                    row[i]++;
            }
        }
        int rowCnt=0;
        int rowCheck=0;
        int colCnt=0;
        int colCheck=0;
        for (int i = 0; i < N; i++) {
            if(col[i]%2!=0) {
                colCnt++;
                colCheck=i+1;
            }
            if(row[i]%2!=0) {
                rowCnt++;
                rowCheck=i+1;
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        if(rowCnt==0 && colCnt==0)
            System.out.println("OK");
        else if(rowCnt==1 && colCnt==1) {//유일하게 해결가능할때
            System.out.printf("Change bit (%d,%d)\n",colCheck,rowCheck);
        }
        else System.out.println("Corrupt");

    }
}
