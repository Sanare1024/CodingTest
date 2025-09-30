package bruteForce;

import java.util.*;
import java.io.*;

public class Bk1018 {
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {            
            String str = br.readLine();
            
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;       
                } else {
                    arr[i][j] = false; 
                }
            }
        }

        int nx = n - 7;
        int my = m - 7;

        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < my; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }


    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean firstColer = arr[x][y];    // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != firstColer) {
                    count++;
                }
                firstColer = (!firstColer);
            }
            firstColer = !firstColer;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
