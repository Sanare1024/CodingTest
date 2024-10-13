package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk2458_floydWarshall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] possible =  new boolean[n + 1][n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            possible[a][b] = true;
        }

        //플로우드워셜 경출도
        for (int k = 1; k < n + 1; k++){
            for (int i = 1; i < n + 1; i ++){
                for (int j = 1; j < n + 1; j++){
                    if(possible[i][k] && possible[k][j]){
                        possible[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        for()

    }
}
