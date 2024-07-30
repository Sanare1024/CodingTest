package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk2748__chain10870 { // 1646
    //10870도 똑같은 피보나치여서 넣어봤는데 시간초과 실패
    // 차이점 이번문제가 10870보다 메모리도 절반, 대신 n이 20 -> 90으로 늠
    //최적화 하라는거 같음 - > 재귀 안쓰고 그냥 쌩 반복문 해봄 //1650시작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 1; //n 일때 피보나치; n에 1넣었을때 0 나오면 안되기때문에 sum = 1
        long f0 = 0; //int 했는데 틀려서 최대수 90 넣었더니 값이 -뜸
        long f1 = 1; //long으로 바꿈 90번째 피보나치 : 2880067194370816120

        for (int i = 1; i < n; i++) { //n은 자연수
            sum = f0 + f1;
            f0 = f1;
            f1 = sum; //sum = f2니까 앞으로 나아가는 방식
        }

        System.out.println(sum);

    }
} //1705 성공  // 원래는 메모이제이션(메모 해둔다) 문제
//https://st-lab.tistory.com/123 보고 다시 해보셈
