package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //N (띄어쓰기 중간에 잘라야 하니까 parseInt 안에 br.readLine 아니라 st.nextToken)
        int m = Integer.parseInt(st.nextToken()); //합구하는 횟수 Mint answer = 0;
        int[][] arr = new int[n][n]; //N크기의 표


        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        int answer = 0; //답 넣을곳








    }
}
