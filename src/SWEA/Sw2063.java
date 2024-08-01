package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw2063 {//1036

    public static void main(String[] args) throws IOException {
        //n개의 점수
        //1. N은 항상 홀수로 주어진다.
        //2. N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199)
        //N 개의 점수들 중, 중간값에 해당하는 점수를 정답으로 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[n / 2]);
    }
} //1043
