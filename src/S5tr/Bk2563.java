package S5tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk2563 {//1550

    public static void main(String[] args) throws IOException {
        //무식하게 푸는거밖에 생각안남...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[100][100];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++){
                    board[j][k] = 7;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++){
                if(board[i][j] == 7) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}  //1558 이게맞넼ㅋㅋㅋㅋㅋㅋㅋ
