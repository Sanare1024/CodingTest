package dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2115 {

    static int n, m, c;
    static int[][] map;
    static int res, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= t; testCase++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0; // 답 넣을곳
            combination();
            System.out.println("#" + testCase + " " + res);
        }
    }

    public static void combination(){
        int max1; //일꾼1의 최대
        int max2; //일꾼2의 최대

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= n - m; j++){
                //일꾼 1 시작
                max = 0;
                max1 = 0;

                getMaxValue(i, j, 0, 0, 0);
                max1 = max; //일꾼1의 최대

                //일꾼 2 시작
                max = 0;
                max2 = 0;

                //같은 열일때
                for (int y = j + m; y <= n - m; y++){
                    getMaxValue(i, y, 0, 0, 0);
                    max2 = Math.max(max2, max);
                }

                //다른 열일때
                for (int x = i + 1; x < n; x++){
                    for(int y = 0; y <= n - m; y++){
                        getMaxValue(x, y, 0, 0, 0);
                        max2 = Math.max(max2, max);
                    }
                }

                // 둘다 선택했으면 최대값 갱신
                res = Math.max(res, max1 + max2);
            }
        }
    }

    public static void getMaxValue(int i, int j, int cnt, int sum, int totalSum){
        //채취한 꿀이 c를 넘으면 retrun
        if(sum > c)
            return;

        //벌통 m개 선택 하면 갱신
        if(cnt == m){
            if(max < totalSum) {
                max = totalSum;
            }
            return;
        }

        //선택
        getMaxValue(i,j + 1, cnt + 1, sum + map[i][j], totalSum + map[i][j] * map[i][j]);
        //선택해제
        getMaxValue(i,j + 1, cnt + 1, sum, totalSum);
    }
}
