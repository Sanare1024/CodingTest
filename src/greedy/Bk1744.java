package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        int minusC = 0;
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine());

            if (numArr[i] <= 0) {
                minusC++;
            }
        }

        Arrays.sort(numArr); // 정렬
        // 음수는 무조건 2개 묶어서 곱하면 좋음(정렬했으니 앞에부터 곱하면 큰거x 다음 큰거)
        // 짝하다가 (음수 + 0)이 1개 남으면
        // 정렬 했으니 마지막은 무조건 0 아니면 제일 작은 홀수니까
        // 짝 안만들고 그냥 더하기
        //

        int res = 0;
        //음수 곱
        for (int i = 1; i < minusC; i = i + 2) { //2칸씩 묶
            res += (numArr[i - 1] * numArr[i]);
        }

        //음수 홀수개?
        if (minusC % 2 == 1) { //맞으면
            res += numArr[minusC - 1];
        }

        int plusC = n - minusC;
        //양수도 홀수개?
        if (plusC % 2 == 1) { //걍 더하기
            res += numArr[minusC]; // 음수개 바로 다음거
        }

        //양수 곱
        for (int i = n - 1; i > minusC; i = i - 2) { // 위에 음수처럼 하면 1이 포함될 경우 결과 틀어져서 if 넣음
            int mul = numArr[i] * numArr[i - 1];
            int sum = numArr[i] + numArr[i - 1];
            if (mul > sum){
                res += mul;
            } else {
                res += sum;
            }
        }
        System.out.println(res);
    }
}
