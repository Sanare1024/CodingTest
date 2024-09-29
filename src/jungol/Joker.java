package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Joker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr= new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int joker=0;
        for (int i = 0; i < N; i++) {
            if(arr[i]==0)
                joker++;//joker 갯수
            else
                break;
        }
        int result=1;
        for (int i = joker; i < N-1; i++) {

            int tempJoker=joker;
            int cnt=1;

            for (int j = i; j < N-1; j++) {

                int gap=arr[j+1]-arr[j]-1;
                if(gap==0)//연속된 숫자면 cnt++;
                    cnt++;

                else if(gap >=0 && gap <= tempJoker) {//아니라면 조커 사용
                    tempJoker=tempJoker-gap;
                    cnt+=gap+1;
                }
                else if(gap > tempJoker) { //joker가 모자라다면?
                    cnt+=tempJoker;//남은 joker 갯수 더하기
                    break;
                }

                if(j==N-2)
                    cnt+=tempJoker;
            }
            if(result<cnt)
                result=cnt;
        }

        if(joker == N)
            result=joker;

        else if(result == 1) {
            result=joker+1;
        }

        System.out.println(result);
    }
}
