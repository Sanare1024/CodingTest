package greedy;

import java.util.*;

public class Bk11399 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arr);


        int prev = 0;    // 이전까지의 대기시간 누적합
        int sum = 0;    // 사람별 대기시간 총합

        for (int i = 0; i < n; i++) {
            // 이전 + 현재시간
            sum += prev + arr[i];
            // 누적합 + 현재
            prev += arr[i];
        }

        System.out.println(sum);
    }
}
