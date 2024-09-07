package baekjoon.b2tr;

import java.util.Scanner;

public class Bk2798 { //0919

    public static void main(String[] args) {
        //바닥에 n개 깔림 그중에 3장을 골라서 m을 넘지않고 최대한 가까운 카드 3장 찾아서 합을 출력
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int sum = 0; // 3개합 넣을곳
        int answer = 0; // 정답

        for(int i = 0; i < n - 2; i++){

            for (int j = i + 1; j < n -1; j++){

                for (int k = j + 1; k < n ; k++){ //범위 설정

                    sum = num[i] + num[j] + num[k]; //합

                    if (sum == m) { //합이 m이면 볼필요 없이 break
                        answer = m;
                        break;
                    }

                    if(answer < sum && sum < m) { // m보다 작지만 합중에 최대값이 생기면 정답에 넣어주기
                        answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
} //0933틀 //0941
