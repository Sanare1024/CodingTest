package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk11404_floydWarshall {

    static int n, m;
    static int distance[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == j){
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 1000000000; //충분히 큰 숫자로 초기화
                }
            }
        }

        for (int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(distance[start][end] > value) distance[start][end] = value;
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if (distance[i][j] == 1000000000){
                    sb.append("0").append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void floydWarshall(){
        //경출도(경유지 출발지 도착지 순서로 for문)
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
