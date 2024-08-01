package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Sw1859 {//1302

    public static void main(String[] args) throws IOException {
        //t의 테스트케이스
        //n일동안 연속 매매가를 암
        //첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
        //둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다.
        //각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int a = 0; a < t; a++) {
            //케이스 입력
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //최대값 구하는 알고리즘
            // 앞에서부터 이것저것 개 별 이상한 방법 다 해봤는데 다 틀림 원하는 데로 안나옴 결과값이 1317
            // 열받아서 계속 보는중 1336
            // 뒤에서부터 봤을때 (최대값이 갱신되는 곳) 이 판매 지점 드디어 보임 1352
            // 문제는 앞에 산거 가격 어캐 더할지

            long sum = 0;  //Tq 그와중에 int는 또 수 넘어가게 해놨네
            long max = 0;

            for (int i = arr.length - 1;  i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                } else if (max > arr[i]) {
                    sum = sum + max - arr[i];
                } else { //같을경우
                    continue;
                }
            }

            System.out.println("#" + (a + 1) + " " + sum);
        }
    }
} //1408
