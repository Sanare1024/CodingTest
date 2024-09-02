package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startP = 0;
        int endP = 0;
        int minLength = Integer.MAX_VALUE; //최소값비교할곳
        int sum = 0;

        while(startP <= endP && endP <= n){
            if(sum < s){ //범위안에 합이 s보다 작으면 end한칸 늘리고 합계에 더하기
                sum += arr[endP++];
            } else if(sum >= s){ //합이 조건 충족하면
                minLength = Math.min(minLength, endP - startP); //최소값인지 확인
                sum -= arr[startP++]; // start 포인터 앞으로 한칸 땡기고 합계에서 빼기
            }
        }

        if(minLength == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
