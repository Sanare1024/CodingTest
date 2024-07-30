package B2tr;

import java.util.Scanner;

public class Bk2581 {//1052

    public static void main(String[] args) {
        //M, N <= 10,000 자연수, M <= N
        //소수가 없을 경우는 첫째 줄에 -1
        //M N 사이의 소수의 총합, 그중 최솟값

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0; //총합
        int min = n;

        for (int i = m; i <=n; i++) {
            boolean prime = true;

            if(i == 1) { //1은 소수 아니니 제외
                prime = false;
            }

            for(int j = 2; j < i; j++){ //2부터 m 밑까지 나눴을때 나머지 없으면 소수x
                if(i % j == 0){
                    prime = false;
                    break; //하나라도 있으면 더 볼필요없음
                }
            }

            if(prime) {//prime이 위에 뚫고 true면 sum에 더하기  그리고 최소값도 저장
                if (min > i){
                    min = i;
                }
                sum += i;
            }
        }

        if(sum == 0) { //총합이 0일때 -1출력
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + min);
        }
    }
} //1113
