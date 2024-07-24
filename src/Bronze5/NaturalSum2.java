package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NaturalSum2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        int answer = 0;

        while (left < N) {
            if (sum > M || right ==N) { //합이 M보다 크거나 오른쪽이 끝에 닿았을때
                sum = sum - arr[left]; //
                left++;
            } else {
                sum = sum + arr[right];
                right++;
            }

            if (sum == M) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
