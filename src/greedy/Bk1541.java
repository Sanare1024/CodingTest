package greedy;

import java.util.*;
import java.io.*;

public class Bk1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");

        while (minus.hasMoreTokens()) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            while (plus.hasMoreTokens()) {
                temp += Integer.parseInt(plus.nextToken());
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
