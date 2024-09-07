package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1979 {//1050

    public static void main(String[] args) throws IOException {
        //1. N은 5 이상 15 이하의 정수이다. (5 ≤ N ≤ 15)
        //2. K는 2 이상 N 이하의 정수이다. (2 ≤ K ≤ N)
        //출력 = #1 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int a = 0; a < t; a++) { //t만큼 테스트 케이스
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            //퍼즐 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int blank = 0; //칸 세기용
            int fit = 0; // 맞는곳

            //가로 조건
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 1){
                        blank++;
                    }
                    if (arr[i][j] == 0 || j == n - 1) { //중간에 0을 만났을 경우 or 끝까지 갔을떄
                        if(blank == k){
                            fit++;
                        }
                        blank = 0;
                    }
                }
            }

            //세로조건
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[j][i] == 1){
                        blank++;
                    }
                    if (arr[j][i] == 0 || j == n - 1) { //중간에 0을 만났을 경우 or 끝까지 갔을떄
                        if(blank == k){
                            fit++;
                        }
                        blank = 0;
                    }
                }
            }

            System.out.println("#" + a + " " + fit);
        }
    }
} //1142 씨이벌... ㅈㄴ 힘드네
