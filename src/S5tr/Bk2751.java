package S5tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk2751 { //1428

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }
}//1432 시간초과  //1441 출력부분 for문 안에 sout을 StringBuilder로 바꾸니 성공
